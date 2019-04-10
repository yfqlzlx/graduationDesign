package org.yf.manage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.yf.common.entity.User;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.service.IUserService;

import java.util.Map;

/**
 * @author yfqlzlx
 * @date 2019/4/8 15:39
 */
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {
    private IUserService userService;
    public UserController(IUserService userService){
        this.userService = userService;
    }

    /**
     * 添加用户
     * @param user 用户
     * @return response
     */
    @PostMapping(value = "/add")
    public Response add(@RequestBody User user){
        if(userService.isExist(user)){
            log.debug("用户已存在");
            return new Response(405);
        }
        if(userService.addUser(user)){
            log.debug("添加成功");
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 获得所有的用户，以创建时间排序
     * @return
     */
    @GetMapping(value = "/all")
    public Response getAllUser(@RequestParam(value = "page", defaultValue = "1") int pageNo,
                               @RequestParam(value = "limit", defaultValue = "10") int pageSize){
        return userService.getAllUser(pageNo,pageSize);
    }

    /**
     * 按条件，分页查询用户信息
     * @param param 分页信息和条件
     * @return
     */
    @PostMapping(value = "/query")
    public Response queryUser(@RequestBody PageParam param){
        return new Response(200,userService.queryUser(param));
    }

    /**
     * 根据用户id删除用户
     * @param id id
     * @return
     */
    @DeleteMapping(value = "/del/{id}")
    public Response delUserById(@PathVariable int id){
        if(userService.delUserById(id)){
            return new Response(200);
        }
        return new Response(500);
    }
}

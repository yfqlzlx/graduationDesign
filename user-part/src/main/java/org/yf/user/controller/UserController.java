package org.yf.user.controller;

import org.springframework.web.bind.annotation.*;
import org.yf.common.entity.User;
import org.yf.common.response.Response;
import org.yf.user.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * @author yfqlzlx
 * @date 2019/4/13 14:40
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private IUserService userService;
    public UserController(IUserService userService){
        this.userService = userService;
    }

    /**
     * 用户注册
     * @param user 用户
     * @return response
     */
    @PostMapping(value = "/registry")
        public Response registry(@RequestBody User user){
        if(userService.isExist(user)){
            return new Response(405,"用户已存在");
        }
        if(userService.addUser(user)){
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 登录
     * @param user 输入的账号密码
     * @return response
     */
    @PostMapping(value = "/login")
    public Response login(@RequestBody User user){
        if(userService.login(user)){
            return new Response(200);
        }
        return new Response(405);
    }

    /**
     * 退出登录
     * @param httpSession
     * @return
     */
    @PutMapping(value = "/logout")
    public Response logout(HttpSession httpSession){
        return new Response(200);
    }
}

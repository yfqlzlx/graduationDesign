package org.yf.manage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yfqlzlx
 * @date 2019/4/8 15:39
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @PostMapping(value = "/add")
    public String add(Map<String,Object> obj){
        System.out.println(obj.toString());
        return "123";
    }
}

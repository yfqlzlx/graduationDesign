package org.yf.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制类
 *
 * @author yfqlzlx
 * @date 2019/4/13 15:13
 */
@Controller
public class PageController {


    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/{fileName}.html")
    public String toPage(@PathVariable String fileName){
        return fileName;
    }

    @RequestMapping(value = "/{folderName}/{fileName}.html")
    public String toPage(@PathVariable String folderName, @PathVariable String fileName){
        return folderName + "/" + fileName;
    }
}

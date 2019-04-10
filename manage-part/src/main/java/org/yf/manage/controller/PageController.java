package org.yf.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yfqlzlx
 * @date 2019/4/8 15:45
 *
 *  跳转控制类，负责页面之间的跳转
 */
@Controller
public class PageController {

    /**
     * 跳转到首页
     * @return 首页名
     */
    @RequestMapping(value = "/index")
    public String jumpToIndex(){
        return "index";
    }

    /**
     * 页面跳转
     * @param folderName 文件夹名
     * @param fileName 文件名
     * @return 完整路径
     */
    @RequestMapping(value = "{folderName}/{fileName}.html", method = RequestMethod.GET)
    public String toPage(@PathVariable String folderName, @PathVariable String fileName) {
        return folderName + "/" +fileName;
    }

    @RequestMapping(value = "/{fileName}.html", method = RequestMethod.GET)
    public String toPage(@PathVariable String fileName) {
        return fileName;
    }
}

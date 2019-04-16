package org.yf.manage.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yf.common.response.Response;
import org.yf.manage.service.IGoodsTypeService;

/**
 * @author yfqlzlx
 * @date 2019/4/16 09:57
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/goodsType")

public class GoodsTypeController {

    private IGoodsTypeService goodsTypeService;
    public  GoodsTypeController(IGoodsTypeService goodsTypeService){
        this.goodsTypeService = goodsTypeService;
    }

    /**
     * 获取第一级下拉菜单
     * @return response
     */
    @GetMapping(value = "/first")
    public Response getFirst(){
        return new Response(200,goodsTypeService.getFirstMenu());
    }

    /**
     * 获得子菜单
     * @param typeId 父级菜单id
     * @return  response
     */
    @GetMapping(value = "/child/{typeId}")
    public Response getChild(@PathVariable String typeId){
        return new Response(200,goodsTypeService.getChildMenu(typeId));
    }

}

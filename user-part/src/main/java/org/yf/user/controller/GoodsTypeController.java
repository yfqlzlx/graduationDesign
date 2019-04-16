package org.yf.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yf.common.response.Response;
import org.yf.user.service.IGoodsTypeService;

/**
 * @author yfqlzlx
 * @date 2019/4/16 09:57
 *
 * 商品分类管理
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/goodsType")

public class GoodsTypeController {

    private IGoodsTypeService goodsTypeService;
    public GoodsTypeController(IGoodsTypeService goodsTypeService){
        this.goodsTypeService = goodsTypeService;
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

    /**
     * 获得分组后的菜单
     * @return response
     */
    @GetMapping(value = "/group")
    public Response getGroupedMenu(){
        return new Response(200,goodsTypeService.getGroupedMenu());
    }

    /**
     * 根据大类的id，选择所有子类及其子类下的所有商品分类
     * @param typeId 大类id
     * @return response
     */
    @GetMapping(value = "/info/{typeId}")
    public Response getGoodsTypeInfo(@PathVariable int typeId){
        return new Response(200,goodsTypeService.getGoodsTypeInfo(typeId));
    }
}

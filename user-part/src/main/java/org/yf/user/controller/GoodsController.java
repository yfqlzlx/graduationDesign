package org.yf.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yf.common.response.Response;
import org.yf.user.service.IGoodsService;

/**
 * @author yfqlzlx
 * @date 2019/4/16 16:42
 *
 * 商品管理类
 */
@RestController
@RequestMapping(value = "/api/goods/")
@Slf4j
public class GoodsController {
    private IGoodsService goodsService;
    public GoodsController(IGoodsService goodsService){
        this.goodsService = goodsService;
    }
    /**
     * 根据商品类型，分页查看商品
     * @param goodsTypeId 类型id
     * @return response
     */
    @GetMapping(value = "/all/{goodsTypeId}")
    public Response getPagedGoods(@PathVariable int goodsTypeId,int pageSize,int pageNo){
        return  goodsService.getPagedGoods(pageNo,pageSize,goodsTypeId);
    }

    @GetMapping(value = "/get/{goodsId}")
    public Response getGoodsById(@PathVariable int goodsId){
        return new Response(200,goodsService.getGoodsById(goodsId));
    }
}

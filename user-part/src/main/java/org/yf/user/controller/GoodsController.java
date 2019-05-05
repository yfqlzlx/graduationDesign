package org.yf.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
    public Response getPagedGoods(@PathVariable int goodsTypeId,@RequestParam(value = "page", defaultValue = "1") int pageNo,
                                  @RequestParam(value = "limit", defaultValue = "10") int pageSize){
        return  goodsService.getPagedGoods(pageNo,pageSize,goodsTypeId);
    }

    /**
     * 通过商品id获取商品信息
     * @param goodsId
     * @return
     */
    @GetMapping(value = "/get/{goodsId}")
    public Response getGoodsById(@PathVariable int goodsId){
        return new Response(200,goodsService.getGoodsById(goodsId));
    }

    /**
     * 模糊搜索商品
     * @param goodsName 搜索关键字
     * @param pageNo 当前页
     * @param pageSize 页数大小
     * @return response
     */
    @GetMapping(value = "/search")
    public Response searchGoods(String goodsName,@RequestParam(value = "page", defaultValue = "1") int pageNo,
                                @RequestParam(value = "limit", defaultValue = "20") int pageSize){
        return goodsService.searchGoods(goodsName,pageNo,pageSize);
    }
}

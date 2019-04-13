package org.yf.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.yf.common.entity.Goods;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.service.IGoodsService;

/**
 * @author yfqlzlx
 * @date 2019/4/10 22:25
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/goods")
public class GoodsController {
    private IGoodsService goodsService;
    public GoodsController(IGoodsService goodsService){
        this.goodsService = goodsService;
    }

    /**
     * 添加商品
     * @param goods 待添加商品
     * @return response
     */
    @PostMapping(value = "/add")
    public Response addGoods(@RequestBody Goods goods){
        if(goodsService.addGoods(goods)){
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 分页获取商品
     * @param pageNo 当前页数
     * @param pageSize 分页大小
     * @return response
     */
    @GetMapping(value = "/all")
    public Response getAllGoods(@RequestParam(value = "page", defaultValue = "1") int pageNo,
                                @RequestParam(value = "limit", defaultValue = "10") int pageSize){
        return goodsService.getPagedGoods(pageNo,pageSize);
    }

    /**
     * 根据条件，分页查询商品
     * @param param 查询参数
     * @return response
     */
    @PostMapping(value = "/query")
    public Response queryGoods(@RequestBody PageParam param){
        log.debug("参数:" + param);
        return goodsService.queryGoods(param);
    }

    @DeleteMapping(value = "/del/{id}")
    public Response delGoods(@PathVariable int id){
        if(goodsService.delGoods(id)){
            return new Response(200);
        }
        return new Response(500);
    }
}

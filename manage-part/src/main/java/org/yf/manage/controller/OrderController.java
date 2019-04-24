package org.yf.manage.controller;

import org.springframework.web.bind.annotation.*;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.service.IOrderService;

/**
 * @author yfqlzlx
 * @date 2019/4/24 10:07
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    private IOrderService orderService;
    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }


    /**
     * 查询分页后的订单信息
     * @param pageNo 当前页码
     * @param pageSize 分页大小
     * @return response
     */
    @GetMapping(value = "/all")
    public Response getAll(@RequestParam(value = "page", defaultValue = "1") int pageNo,
                           @RequestParam(value = "limit", defaultValue = "10") int pageSize){
        return orderService.getAll(pageNo,pageSize);
    }

    /**
     * 按条件分页查询订单信息
     * @param param 参数+分页信息
     * @return response
     */
    @PostMapping(value = "/query")
    public Response queryOrders(@RequestBody PageParam param){
        return orderService.queryOrders(param);
    }
}

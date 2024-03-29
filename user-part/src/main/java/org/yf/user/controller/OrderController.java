package org.yf.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yf.common.entity.Orders;
import org.yf.common.response.Response;
import org.yf.user.service.IOrderService;

/**
 * @author yfqlzlx
 * @date 2019/4/22 10:41
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    private IOrderService orderService;
    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    /**
     * 添加订单
     * @param orders 订单
     * @return response
     */
    @PostMapping(value = "/add")
    public Response addOrder(@RequestBody Orders orders){
        if(orderService.addOrder(orders)){
            return new Response(200);
        }
        return new Response(500);
    }

}

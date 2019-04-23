package org.yf.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Orders;
import org.yf.common.entity.SystemCode;
import org.yf.user.mapper.OrderMapper;
import org.yf.user.service.IOrderService;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements IOrderService {

    private OrderMapper orderMapper;
    public OrderServiceImpl(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }
    @Override
    public boolean addOrder(Orders orders) {
        orders.setInsertTime(LocalDateTime.now()).setTotalPrice(orders.getGoodsPrice() * orders.getGoodsNum()).setState(SystemCode.VALID);
        System.out.println(123);
        return orderMapper.insert(orders) > 0;
    }
}

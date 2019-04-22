package org.yf.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Order;
import org.yf.user.mapper.OrderMapper;
import org.yf.user.service.IOrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public boolean addOrder(Order order) {
        return false;
    }
}

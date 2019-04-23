package org.yf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.Orders;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
public interface IOrderService extends IService<Orders> {

    /**
     * 添加订单
     * @param orders 订单
     * @return response
     */
    boolean addOrder(Orders orders);
}

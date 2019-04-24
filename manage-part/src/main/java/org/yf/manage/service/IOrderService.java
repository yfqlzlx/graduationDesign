package org.yf.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.Orders;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;

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
     * 分页获取全部订单
     * @param pageNo 当前页
     * @param pageSize 分页大小
     * @return response
     */
    Response getAll(int pageNo, int pageSize);

    /**
     * 按条件分页查询订单
     * @param param 参数+分页信息
     * @return response
     */
    Response queryOrders(PageParam param);
}

package org.yf.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Orders;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.mapper.OrderMapper;
import org.yf.manage.service.IOrderService;

import java.util.Map;

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
    public Response getAll(int pageNo, int pageSize) {
        IPage resultPage = orderMapper.selectPage(new Page<>(pageNo,pageSize), new QueryWrapper<Orders>().orderByDesc("insert_time"));
        return new Response(200,resultPage.getRecords()).setTotalSize(resultPage.getTotal());
    }

    @Override
    public Response queryOrders(PageParam param) {
        IPage page = new Page(param.getPage(),param.getLimit());
        Map<String,Object> map = JSON.parseObject(param.getParam().toString());
        IPage<Orders> resultPage = orderMapper.queryOrders(page,map);
        return new Response(200,resultPage.getRecords()).setTotalSize(resultPage.getTotal());
    }
}

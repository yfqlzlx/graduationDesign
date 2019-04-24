package org.yf.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yf.common.entity.Orders;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
public interface OrderMapper extends BaseMapper<Orders> {


    IPage<Orders> queryOrders(IPage page, Map<String, Object> map);
}

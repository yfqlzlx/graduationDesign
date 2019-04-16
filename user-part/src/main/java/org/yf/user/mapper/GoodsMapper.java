package org.yf.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.yf.common.entity.Goods;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yf
 * @since 2019-04-11
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<Goods> queryGoods(IPage page, Goods goods);
}

package org.yf.manage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.yf.common.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    int  insertGoods(Goods goods);
}

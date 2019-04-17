package org.yf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.Goods;
import org.yf.common.entity.GoodsDto;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2019-04-11
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 根据商品分类，查询分类下的所有商品
     * @param pageNo 当前页
     * @param pageSize 分页大小
     * @return response
     */
    Response getPagedGoods(int pageNo, int pageSize,int goodsTypeId);

    /**
     * 通过商品id查询商品详情 + 图片
     * @param goodsId 商品id
     * @return response
     */
    GoodsDto getGoodsById(int goodsId);
}

package org.yf.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Goods;
import org.yf.common.response.Response;
import org.yf.user.mapper.GoodsMapper;
import org.yf.user.service.IGoodsService;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-11
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    private GoodsMapper goodsMapper;
    public GoodsServiceImpl(GoodsMapper goodsMapper){
        this.goodsMapper = goodsMapper;
    }


    @Override
    public Response getPagedGoods(int pageNo, int pageSize,int goodsTypeId) {
        IPage page = new Page(pageNo,pageSize);
        IPage resultPage = goodsMapper.selectPage(page, new QueryWrapper<Goods>().eq("goods_type", goodsTypeId).orderByDesc("insert_time"));
        return new Response(200,resultPage.getRecords()).setTotalSize(resultPage.getTotal());
    }
}

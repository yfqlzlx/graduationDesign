package org.yf.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yf.common.entity.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.SystemCode;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.mapper.GoodsMapper;
import org.yf.manage.service.IGoodsService;

import java.time.LocalDateTime;

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
    public boolean addGoods(Goods goods) {
        goods.setInsertTime(LocalDateTime.now()).setStatus(SystemCode.VALID);
        return goodsMapper.insert(goods) > 0;
    }

    @Override
    public Response getPagedGoods(int pageNo, int pageSize) {
        IPage<Goods> goodsIPage = goodsMapper.selectPage(new Page<Goods>(pageNo, pageSize), new QueryWrapper<Goods>().orderByDesc("insert_time"));
        return new Response(200,goodsIPage.getRecords()).setTotalSize(goodsIPage.getTotal());
    }

    @Override
    public Response queryGoods(PageParam param) {
        IPage page = new Page(param.getPage(),param.getLimit());
        Goods goods = JSON.parseObject(param.getParam().toString()).toJavaObject(Goods.class);
        IPage<Goods> quertGoods = goodsMapper.queryGoods(page,goods);
        return new Response(200,quertGoods.getRecords()).setTotalSize(quertGoods.getTotal());
    }

    @Override
    public boolean delGoods(int id) {
        return goodsMapper.deleteById(id) > 0;
    }
}

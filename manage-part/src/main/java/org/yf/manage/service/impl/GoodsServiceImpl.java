package org.yf.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.yf.common.entity.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.GoodsImg;
import org.yf.common.entity.GoodsVo;
import org.yf.common.entity.SystemCode;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.mapper.GoodsImgMapper;
import org.yf.manage.mapper.GoodsMapper;
import org.yf.manage.service.IGoodsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private GoodsImgMapper goodsImgMapper;
    public GoodsServiceImpl(GoodsMapper goodsMapper,GoodsImgMapper goodsImgMapper){
        this.goodsMapper = goodsMapper;
        this.goodsImgMapper  = goodsImgMapper;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addGoods(GoodsVo vo) throws Exception {
        Goods goods = vo.getGoods();
        goods.setInsertTime(LocalDateTime.now()).setStatus(SystemCode.VALID);
        goodsMapper.insertGoods(goods);
        if(goods.getId() < 1){
            // 没有插入成功
            throw new Exception("新增失败");
        }
        // 查询刚插入的商品id
//        Goods insertGoods = goodsMapper.selectOne(new QueryWrapper<Goods>().eq("goods_name", goods.getGoodsName()).eq("goods_type", goods.getGoodsType()).eq("goods_price", goods.getGoodsPrice()).eq("goods_price", goods.getGoodsPrice()).eq("insert_time", goods.getInsertTime()));
//        if(insertGoods == null){
//            throw new Exception("新增失败");
//        }
        System.out.println("##################ID:"+goods.getId());
        vo.getImgUrls().forEach(item-> goodsImgMapper.insert(new GoodsImg().setGoodsId(goods.getId()).setUrl(item)));
        return true;
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

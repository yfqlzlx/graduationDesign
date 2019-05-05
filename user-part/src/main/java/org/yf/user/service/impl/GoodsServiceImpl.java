package org.yf.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Goods;
import org.yf.common.vo.GoodsDto;
import org.yf.common.entity.GoodsImg;
import org.yf.common.response.Response;
import org.yf.user.mapper.GoodsImgMapper;
import org.yf.user.mapper.GoodsMapper;
import org.yf.user.service.IGoodsService;

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
        this.goodsImgMapper = goodsImgMapper;
        this.goodsMapper = goodsMapper;
    }


    @Override
    public Response getPagedGoods(int pageNo, int pageSize,int goodsTypeId) {
        IPage<Goods> page = new Page<>(pageNo,pageSize);
        IPage<Goods> resultPage = goodsMapper.selectPage(page, new QueryWrapper<Goods>().eq("goods_type", goodsTypeId).orderByDesc("insert_time"));
        List<Goods> records = resultPage.getRecords();
        List<GoodsDto> ret = new LinkedList<>();
        records.forEach(item->{
            List<GoodsImg> goodsImgs = goodsImgMapper.selectList(new QueryWrapper<GoodsImg>().eq("goods_id", item.getId()).orderByAsc("id"));
            if(goodsImgs != null && goodsImgs.size() > 0){
                ret.add(new GoodsDto().setGoods(item).setImgUrl(goodsImgs.get(0).getUrl()));
                return;
            }
            ret.add(new GoodsDto().setGoods(item));
        });
        return new Response(200,ret).setTotalSize(resultPage.getTotal());
    }

    @Override
    public GoodsDto getGoodsById(int goodsId) {
        GoodsDto ret = new GoodsDto();
        // 查询商品
        Goods goods = goodsMapper.selectById(goodsId);
        ret.setGoods(goods);
        // 查询图片
        List<GoodsImg> goodsImgs = goodsImgMapper.selectList(new QueryWrapper<GoodsImg>().eq("goods_id", goodsId).orderByDesc("id"));
        if(goodsImgs == null || goodsImgs.size() == 0){
            ret.setImgUrls(new ArrayList<>());
        }else {
            List<String> imgUrls = new LinkedList<>();
            goodsImgs.forEach(item-> imgUrls.add(item.getUrl()));
            ret.setImgUrls(imgUrls);
        }
        return ret;
    }

    @Override
    public Response searchGoods(String goodsName, int pageNo, int pageSize) {
        goodsMapper.searchGoods(new Page<>(pageNo,pageSize),goodsName);


        IPage<Goods> resultPage = goodsMapper.searchGoods(new Page<>(pageNo,pageSize), goodsName);
        List<Goods> records = resultPage.getRecords();
        List<GoodsDto> ret = new LinkedList<>();
        records.forEach(item->{
            List<GoodsImg> goodsImgs = goodsImgMapper.selectList(new QueryWrapper<GoodsImg>().eq("goods_id", item.getId()).orderByAsc("id"));
            if(goodsImgs != null && goodsImgs.size() > 0){
                ret.add(new GoodsDto().setGoods(item).setImgUrl(goodsImgs.get(0).getUrl()));
                return;
            }
            ret.add(new GoodsDto().setGoods(item));
        });
        return new Response(200,ret).setTotalSize(resultPage.getTotal());
    }
}

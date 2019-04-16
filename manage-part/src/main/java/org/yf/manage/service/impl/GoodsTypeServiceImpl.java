package org.yf.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.yf.common.entity.GoodsType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.manage.mapper.GoodsTypeMapper;
import org.yf.manage.service.IGoodsTypeService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-16
 */
@Service
@Slf4j
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements IGoodsTypeService {

    private GoodsTypeMapper goodsTypeMapper;
    public GoodsTypeServiceImpl(GoodsTypeMapper goodsTypeMapper){
        this.goodsTypeMapper = goodsTypeMapper;
    }
    @Override
    public List<GoodsType> getFirstMenu() {
        return goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id",0).orderByAsc("sort"));
    }

    @Override
    public List<GoodsType> getChildMenu(String typeId) {
        return goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id",typeId).orderByAsc("sort"));
    }

}

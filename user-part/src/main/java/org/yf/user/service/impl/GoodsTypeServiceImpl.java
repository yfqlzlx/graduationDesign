package org.yf.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yf.common.entity.GoodsType;
import org.yf.user.mapper.GoodsTypeMapper;
import org.yf.user.service.IGoodsTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<GoodsType> getChildMenu(String typeId) {
        return goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id",typeId).orderByAsc("sort"));
    }

    @Override
    public Map<Integer,Object> getGroupedMenu() {
        Map<Integer,Object> map = new HashMap<>(4);
        List<GoodsType> parentList = goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id", 0).orderByAsc("sort"));
        if(parentList == null){
            return  null;
        }
        parentList.forEach(item->{
            List<GoodsType> goodsTypes = goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id", item.getTypeId()));
            map.put(item.getTypeId(),goodsTypes);
        });
        return map;
    }

    @Override
    public Map<String, List<GoodsType>> getGoodsTypeInfo(int typeId) {
        // 获取子类
        Map<String, List<GoodsType>> map = new HashMap<>(3);
        List<GoodsType> goodsTypes = goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id", typeId).orderByAsc("sort"));
        goodsTypes.forEach(item->{
            List<GoodsType> goodsTypeInfo = goodsTypeMapper.selectList(new QueryWrapper<GoodsType>().eq("parent_id", item.getTypeId()).orderByAsc("sort"));
            map.put(item.getTypeName(),goodsTypeInfo);
        });
        log.debug("详细分类:"+map);
        return map;
    }
}

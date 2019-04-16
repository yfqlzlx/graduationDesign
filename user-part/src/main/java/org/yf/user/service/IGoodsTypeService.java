package org.yf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2019-04-16
 */
public interface IGoodsTypeService extends IService<GoodsType> {

    /**
     * 获得子菜单
     * @param typeId 父级菜单id
     * @return response
     */
    List<GoodsType> getChildMenu(String typeId);

    /**
     * 获取分组后的菜单
     * @return response
     */
    Map<Integer,Object> getGroupedMenu();

    /**
     * 根据商品大类获取子类及其子类下的所有商品分类
     * @param typeId 大类id
     * @return response
     */
    Map<String,List<GoodsType>> getGoodsTypeInfo(int typeId);
}

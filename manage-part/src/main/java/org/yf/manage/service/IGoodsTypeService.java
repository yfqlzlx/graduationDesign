package org.yf.manage.service;

import org.yf.common.entity.GoodsType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
     * 获得第一级菜单
     * @return response
     */
    List<GoodsType> getFirstMenu();

    /**
     * 获得子菜单
     * @param typeId 父级菜单id
     * @return response
     */
    List<GoodsType> getChildMenu(String typeId);
}

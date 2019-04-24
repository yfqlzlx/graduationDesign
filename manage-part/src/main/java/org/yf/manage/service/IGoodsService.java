package org.yf.manage.service;

import org.yf.common.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.vo.GoodsVo;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;

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
     * 添加商品
     * @param vo 待添加商品信息(参数+图片地址)
     * @return 是否成功
     */
    boolean addGoods(GoodsVo vo) throws Exception;

    /**
     * 获取分页后的商品
     * @param pageNo 当前页
     * @param pageSize 分页大小
     * @return response
     */
    Response getPagedGoods(int pageNo, int pageSize);

    /**
     * 按条件分页查询商品
     * @param param 参数
     * @return response
     */
    Response queryGoods(PageParam param);

    /**
     * 根据商品id删除商品
     * @param id 商品id
     * @return 是否成功
     */
    boolean delGoods(int id);
}

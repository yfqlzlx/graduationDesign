package org.yf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.Address;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
public interface IAddressService extends IService<Address> {

    /**
     * 通过用户id获取收货地址
     * @param userId 用户id
     * @return response
     */
    List<Address> getAllAdressByUserId(int userId);

    /**
     * 添加地址
     * @param address 地址
     * @return response
     */
    boolean addAddress(Address address);

    /**
     * 通过地址id删除地址
     * @param id 地址id
     * @return response
     */
    boolean delAddress(int id);
}

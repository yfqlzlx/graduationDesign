package org.yf.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yf.common.entity.Address;
import org.yf.user.mapper.AddressMapper;
import org.yf.user.service.IAddressService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    private AddressMapper addressMapper;
    public AddressServiceImpl(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> getAllAdressByUserId(int userId) {
        return addressMapper.selectList(new QueryWrapper<Address>().eq("user_id",userId).orderByDesc("id"));
    }

    @Override
    public boolean addAddress(Address address) {
        return addressMapper.insert(address) > 0;
    }

    @Override
    public boolean delAddress(int id) {
        return addressMapper.deleteById(id) > 0;
    }
}

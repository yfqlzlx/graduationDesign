package org.yf.user.controller;

import org.springframework.web.bind.annotation.*;
import org.yf.common.entity.Address;
import org.yf.common.response.Response;
import org.yf.user.service.IAddressService;

/**
 * @author yfqlzlx
 * @date 2019/4/21 13:45
 *
 * 地址管理类
 */
@RestController
@RequestMapping(value = "/api/address")
public class AddressController {

    private IAddressService addressService;
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    /**
     * 通过用户id获取用户的地址
     * @param userId  用户id
     * @return response
     */
    @GetMapping(value = "/all/{userId}")
    public Response getAllAdressByUserId(@PathVariable int userId){
        return new Response(200,addressService.getAllAdressByUserId(userId));
    }

    /**
     * 添加地址
     * @param address 地址
     * @return response
     */
    @PostMapping(value = "/add")
    public Response addAddress(@RequestBody Address address){
        if(addressService.addAddress(address)){
            return new Response(200);
        }
        return  new Response(500);
    }


    /**
     * 通过地址id删除地址
     * @param id 地址id
     * @return response
     */
    @DeleteMapping(value = "/del/{id}")
    public Response delAddress(@PathVariable int id){
        if(addressService.delAddress(id)){
            return new Response(200);
        }
        return  new Response(500);
    }
}

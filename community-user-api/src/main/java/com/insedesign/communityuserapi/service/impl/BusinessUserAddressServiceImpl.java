package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserAddressMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;
import com.insedesign.communityuserapi.service.BusinessUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessUserAddressServiceImpl implements BusinessUserAddressService {

    @Resource
    private BusinessUserAddressMapper userAddressMapper;


    @Override
    public int insert(BusinessUserAddress userAddress) {
        return userAddressMapper.insert(userAddress);
    }

    @Override
    public BusinessUserAddress selectByUserId(String userId) {
        return userAddressMapper.selectById(userId);
    }
}

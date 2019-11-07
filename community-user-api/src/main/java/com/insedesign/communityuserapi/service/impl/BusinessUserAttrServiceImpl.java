package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserAddressMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;
import com.insedesign.communityuserapi.model.entity.BusinessUserAttr;
import com.insedesign.communityuserapi.service.BusinessUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
@Service
public class BusinessUserAttrServiceImpl implements BusinessUserAddressService {
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

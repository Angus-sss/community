package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserAddressMapper;
import com.insedesign.communityuserapi.model.dto.UserAddressDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;
import com.insedesign.communityuserapi.service.BusinessUserAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class BusinessUserAddressServiceImpl implements BusinessUserAddressService {

    @Resource
    private BusinessUserAddressMapper userAddressMapper;


    @Override
    public BusinessUserAddress insert(UserAddressDto userAddressDto) {
        BusinessUserAddress businessUserAddress = new BusinessUserAddress();
        BeanUtils.copyProperties(userAddressDto,businessUserAddress);
        if (0<userAddressMapper.insert(businessUserAddress)){
            return selectByUserId(userAddressDto.getUserId());
        }
        return null;
    }

    @Override
    public int del(String id) {
        return 0;
    }

    @Override
    public BusinessUserAddress update(UserAddressDto userAddressDto) {
        BusinessUserAddress businessUserAddress = new BusinessUserAddress();
        BeanUtils.copyProperties(userAddressDto,businessUserAddress);
        if (0<userAddressMapper.update(businessUserAddress,null)){
            return selectByUserId(userAddressDto.getUserId());
        }
        return null;
    }

    @Override
    public BusinessUserAddress selectByUserId(String userId) {
        return userAddressMapper.selectById(userId);
    }
}

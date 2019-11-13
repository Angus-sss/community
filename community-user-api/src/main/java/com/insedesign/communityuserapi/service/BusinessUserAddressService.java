package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.dto.UserAddressDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
public interface BusinessUserAddressService {

    BusinessUserAddress insert(UserAddressDto userAddressDto);

    int del(String id);

    BusinessUserAddress update(UserAddressDto userAddressDto);

    BusinessUserAddress selectByUserId(String userId);

}

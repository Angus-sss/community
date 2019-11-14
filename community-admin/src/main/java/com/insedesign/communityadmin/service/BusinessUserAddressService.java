package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.model.entity.BusinessUserAddress;
import com.insedesign.model.dto.UserAddressDto;

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

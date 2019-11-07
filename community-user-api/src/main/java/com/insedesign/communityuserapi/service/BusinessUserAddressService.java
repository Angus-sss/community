package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
public interface BusinessUserAddressService {

    int insert(BusinessUserAddress userAddress);

    BusinessUserAddress selectByUserId(String userId);

}

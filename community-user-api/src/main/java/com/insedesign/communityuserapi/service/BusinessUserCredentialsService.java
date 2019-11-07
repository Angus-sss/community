package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.entity.BusinessUserCredentials;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public interface BusinessUserCredentialsService {
    int insert(BusinessUserCredentials userCredentials);

    BusinessUserCredentials selectByUserId(String userId);
}

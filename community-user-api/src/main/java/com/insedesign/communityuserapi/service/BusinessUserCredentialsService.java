package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.dto.UserCredentialsDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserCredentials;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public interface BusinessUserCredentialsService {
    BusinessUserCredentials insert(UserCredentialsDto userCredentialsDto);

    int del(String id);

    BusinessUserCredentials update(UserCredentialsDto userCredentialsDto);

    BusinessUserCredentials selectByUserId(String userId);
}

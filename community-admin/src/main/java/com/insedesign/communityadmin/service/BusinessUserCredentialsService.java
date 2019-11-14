package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.model.entity.BusinessUserCredentials;
import com.insedesign.model.dto.UserCredentialsDto;

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

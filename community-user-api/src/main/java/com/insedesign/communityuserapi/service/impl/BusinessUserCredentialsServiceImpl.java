package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserCredentialsMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUserCredentials;
import com.insedesign.communityuserapi.service.BusinessUserCredentialsService;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public class BusinessUserCredentialsServiceImpl implements BusinessUserCredentialsService {
    @Resource
    private BusinessUserCredentialsMapper userCredentialsMapper;

    @Override
    public int insert(BusinessUserCredentials userCredentials) {
        return userCredentialsMapper.insert(userCredentials);
    }

    @Override
    public BusinessUserCredentials selectByUserId(String userId) {
        return userCredentialsMapper.selectById(userId);
    }
}

package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserTagMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUserTag;
import com.insedesign.communityuserapi.service.BusinessUserTagService;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public class BusinessUserTagServiceImpl implements BusinessUserTagService {
    @Resource
    private BusinessUserTagMapper userTagMapper;

    @Override
    public int insert(BusinessUserTag userTag) {
        return userTagMapper.insert(userTag);
    }

    @Override
    public BusinessUserTag selectByUserId(String userId) {
        return userTagMapper.selectById(userId);
    }
}

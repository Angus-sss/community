package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.entity.BusinessUserTag;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public interface BusinessUserTagService {
    int insert(BusinessUserTag userTag);

    BusinessUserTag selectByUserId(String userId);
}

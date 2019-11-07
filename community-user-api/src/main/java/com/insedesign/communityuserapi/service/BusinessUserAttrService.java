package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.entity.BusinessUserAttr;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
public interface BusinessUserAttrService {
    int insert(BusinessUserAttr userAttr);

    BusinessUserAttr selectByUserId(String userId);
}

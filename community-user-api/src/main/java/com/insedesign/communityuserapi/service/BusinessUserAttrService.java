package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.dto.UserAttrDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserAttr;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
public interface BusinessUserAttrService {
    BusinessUserAttr insert(UserAttrDto userAttrDto);

    int del(String id);

    BusinessUserAttr update(UserAttrDto userAttrDto);

    BusinessUserAttr selectByUserId(String userId);
}

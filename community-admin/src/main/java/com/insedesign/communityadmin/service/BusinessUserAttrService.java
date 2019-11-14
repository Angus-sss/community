package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.model.entity.BusinessUserAttr;
import com.insedesign.model.dto.UserAttrDto;

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

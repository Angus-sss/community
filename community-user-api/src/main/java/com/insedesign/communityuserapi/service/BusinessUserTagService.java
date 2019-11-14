package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.model.dto.UserTagDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserTag;

import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
public interface BusinessUserTagService {
    BusinessUserTag insert(UserTagDto dto);

    List<BusinessUserTag> selectList(String userId);

    int del(String id);

    BusinessUserTag update(UserTagDto dto);

    BusinessUserTag selectByUserId(String userId);
}

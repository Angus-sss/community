package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.model.entity.BusinessUserTag;
import com.insedesign.model.dto.UserTagDto;

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

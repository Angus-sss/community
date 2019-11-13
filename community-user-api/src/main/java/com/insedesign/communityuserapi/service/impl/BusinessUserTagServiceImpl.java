package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.mapper.BusinessUserTagMapper;
import com.insedesign.communityuserapi.model.dto.UserTagDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserTag;
import com.insedesign.communityuserapi.service.BusinessUserTagService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
@Service
public class BusinessUserTagServiceImpl implements BusinessUserTagService {
    @Resource
    private BusinessUserTagMapper userTagMapper;

    @Override
    public BusinessUserTag insert(UserTagDto userTagDto) {
        BusinessUserTag businessUserTag = new BusinessUserTag();
        BeanUtils.copyProperties(userTagDto,businessUserTag);
        if (0<userTagMapper.insert(businessUserTag)){
            return selectByUserId(userTagDto.getUserId());
        }
        return null;
    }

    @Override
    public int del(String id) {
        return userTagMapper.deleteById(id);
    }

    @Override
    public BusinessUserTag update(UserTagDto userTagDto) {
        BusinessUserTag businessUserTag = new BusinessUserTag();
        BeanUtils.copyProperties(userTagDto,businessUserTag);
        if (0<userTagMapper.update(businessUserTag,null)){
            return selectByUserId(userTagDto.getUserId());
        }
        return null;
    }

    @Override
    public BusinessUserTag selectByUserId(String userId) {
        return userTagMapper.selectById(userId);
    }
}

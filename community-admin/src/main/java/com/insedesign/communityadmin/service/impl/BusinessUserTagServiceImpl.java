package com.insedesign.communityadmin.service.impl;

import com.insedesign.communityadmin.mapper.BusinessUserTagMapper;
import com.insedesign.communityadmin.service.BusinessUserTagService;
import com.insedesign.communityadmin.model.entity.BusinessUserTag;
import com.insedesign.model.dto.UserTagDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<BusinessUserTag> selectList(String userId) {
        return userTagMapper.selectList(null);
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

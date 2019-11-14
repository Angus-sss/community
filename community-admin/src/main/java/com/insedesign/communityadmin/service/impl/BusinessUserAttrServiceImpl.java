package com.insedesign.communityadmin.service.impl;

import com.insedesign.communityadmin.mapper.BusinessUserAttrMapper;
import com.insedesign.communityadmin.service.BusinessUserAttrService;
import com.insedesign.communityadmin.model.entity.BusinessUserAttr;
import com.insedesign.model.dto.UserAttrDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:48
 * @Explain:
 */
@Service
public class BusinessUserAttrServiceImpl implements BusinessUserAttrService {
    @Resource
    private BusinessUserAttrMapper userAttrMapper;


    @Override
    public BusinessUserAttr insert(UserAttrDto userAttrDto) {
        BusinessUserAttr businessUserAttr = new BusinessUserAttr();
        BeanUtils.copyProperties(userAttrDto,businessUserAttr);
        if (0<userAttrMapper.insert(businessUserAttr)){
            return selectByUserId(userAttrDto.getUserId());
        }
        return null;
    }

    @Override
    public int del(String id) {
        return userAttrMapper.deleteById(id);
    }

    @Override
    public BusinessUserAttr update(UserAttrDto userAttrDto) {
        BusinessUserAttr businessUserAttr = new BusinessUserAttr();
        BeanUtils.copyProperties(userAttrDto,businessUserAttr);
        if (0<userAttrMapper.update(businessUserAttr,null)){
            return selectByUserId(userAttrDto.getUserId());
        }
        return null;
    }

    @Override
    public BusinessUserAttr selectByUserId(String userId) {
        return userAttrMapper.selectById(userId);
    }

}

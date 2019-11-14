package com.insedesign.communityadmin.service.impl;

import com.insedesign.communityadmin.mapper.BusinessUserCredentialsMapper;
import com.insedesign.communityadmin.service.BusinessUserCredentialsService;
import com.insedesign.communityadmin.model.entity.BusinessUserCredentials;
import com.insedesign.model.dto.UserCredentialsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:49
 * @Explain:
 */
@Service
public class BusinessUserCredentialsServiceImpl implements BusinessUserCredentialsService {
    @Resource
    private BusinessUserCredentialsMapper userCredentialsMapper;

    @Override
    public BusinessUserCredentials insert(UserCredentialsDto userCredentialsDto) {
        BusinessUserCredentials businessUserCredentials = new BusinessUserCredentials();
        BeanUtils.copyProperties(userCredentialsDto,businessUserCredentials);
        if (0<userCredentialsMapper.insert(businessUserCredentials)){
            return selectByUserId(userCredentialsDto.getUserId());
        }
        return null;
    }

    @Override
    public int del(String id) {
        return userCredentialsMapper.deleteById(id);
    }

    @Override
    public BusinessUserCredentials update(UserCredentialsDto userCredentialsDto) {
        BusinessUserCredentials businessUserCredentials = new BusinessUserCredentials();
        BeanUtils.copyProperties(userCredentialsDto,businessUserCredentials);
        if (0<userCredentialsMapper.update(businessUserCredentials,null)){
            return selectByUserId(userCredentialsDto.getUserId());
        }
        return null;
    }

    @Override
    public BusinessUserCredentials selectByUserId(String userId) {
        return userCredentialsMapper.selectById(userId);
    }
}

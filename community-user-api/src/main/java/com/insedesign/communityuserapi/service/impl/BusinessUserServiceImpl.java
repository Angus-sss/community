package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.common.utils.Md5Utils;
import com.insedesign.communityuserapi.mapper.BusinessUserMapper;
import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.dto.UpdateUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;
import com.insedesign.communityuserapi.service.BusinessUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 22:11
 * @Explain:
 */
@Service
public class BusinessUserServiceImpl implements BusinessUserService {
    @Resource
    private BusinessUserMapper userMapper;

    @Override
    public BusinessUser selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int insert(RegisterUserDto userDto) {
        //Md5加密
        userDto.setPassword(Md5Utils.encrypt3Times(userDto.getPassword()));
        //执行service
        BusinessUser businessUser = new BusinessUser();
        BeanUtils.copyProperties(userDto,businessUser);
        return userMapper.insert(businessUser);
    }

    @Override
    public BusinessUser selectByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public BusinessUser selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public BusinessUser selectByTel(String tel) {
        return userMapper.selectByTel(tel);
    }

    @Override
    public int checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public int checkTel(String tel) {
        return userMapper.checkTel(tel);
    }

    @Override
    public int checkUserId(String userId) {
        return userMapper.checkUserId(userId);
    }

    @Override
    public int updateUser(UpdateUserDto updateUserDto) {
        BusinessUser user = new BusinessUser();
        BeanUtils.copyProperties(updateUserDto,user);
        return   userMapper.updateById(user);
    }

    @Override
    public int offAccount(String userId) {
        return userMapper.offAccount(Base.ACCOUNT_OFF,userId);
    }


}

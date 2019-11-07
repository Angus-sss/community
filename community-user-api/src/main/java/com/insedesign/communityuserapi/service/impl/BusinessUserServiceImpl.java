package com.insedesign.communityuserapi.service.impl;

import com.insedesign.communityuserapi.common.utils.Md5Utils;
import com.insedesign.communityuserapi.mapper.BusinessUserMapper;
import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.dto.UpdateUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;
import com.insedesign.communityuserapi.service.BusinessUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        //生成注册时间
        userDto.setCreateTime(new Date());
        System.out.println(userDto);
        //执行service
        BusinessUser businessUser = new BusinessUser();
        BeanUtils.copyProperties(userDto,businessUser);
        return userMapper.insert(businessUser);
    }

    @Override
    public BusinessUser selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public BusinessUser selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public int checkName(String username) {
        return 0;
    }

    @Override
    public int checkEmail(String email) {
        return 0;
    }

    @Override
    public int updateUser(UpdateUserDto updateUserDto) {
        BusinessUser user = new BusinessUser();
        BeanUtils.copyProperties(updateUserDto,user);
        return   userMapper.update(user,null);
    }


}

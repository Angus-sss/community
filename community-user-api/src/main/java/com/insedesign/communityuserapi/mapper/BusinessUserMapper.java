package com.insedesign.communityuserapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUser;

public interface BusinessUserMapper extends BaseMapper<BusinessUser> {

    BusinessUser selectByName(String name);


    BusinessUser selectByEmail(String email);


    int checkName(String name);


    int checkEmail(String email);
}
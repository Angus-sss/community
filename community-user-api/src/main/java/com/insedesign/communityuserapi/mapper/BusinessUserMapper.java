package com.insedesign.communityuserapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.insedesign.communityuserapi.model.entity.BusinessUser;

public interface BusinessUserMapper extends BaseMapper<BusinessUser> {

    BusinessUser selectByUserId(String userId);


    BusinessUser selectByEmail(String email);


    BusinessUser selectByTel(String tel);


    int checkUserId(String userId);


    int checkEmail(String email);

    int checkTel(String tel);

    int offAccount(Integer operate,String userId);


}
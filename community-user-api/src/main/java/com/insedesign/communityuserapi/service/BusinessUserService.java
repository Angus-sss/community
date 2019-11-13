package com.insedesign.communityuserapi.service;


import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.dto.UpdateUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;

/**
 * @author: NALHOUG
 * @time: 2019/10/31 15:30
 * @explain:
 */

public interface BusinessUserService {
    BusinessUser selectById(int id);

    int insert(RegisterUserDto user);


    BusinessUser selectByUserId(String userId);

    BusinessUser selectByEmail(String email);

    BusinessUser selectByTel(String tel);

    int checkEmail(String email);

    int checkTel(String tel);

    int checkUserId(String userId);

    int updateUser(UpdateUserDto updateUserDto);

    int offAccount(String userId);
}

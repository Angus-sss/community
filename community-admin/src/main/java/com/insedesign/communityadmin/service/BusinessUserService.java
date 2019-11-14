package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.model.entity.BusinessUser;
import com.insedesign.model.dto.RegisterUserDto;
import com.insedesign.model.dto.UpdateUserDto;

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

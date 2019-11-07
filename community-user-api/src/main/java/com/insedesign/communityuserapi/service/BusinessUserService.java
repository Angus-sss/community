package com.insedesign.communityuserapi.service;


import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;

/**
 * @author: NALHOUG
 * @time: 2019/10/31 15:30
 * @explain:
 */

public interface BusinessUserService {
    int insert(RegisterUserDto user);

    BusinessUser selectByName(String username);

    BusinessUser selectByEmail(String email);

    int checkName(String username);

    int checkEmail(String email);
}

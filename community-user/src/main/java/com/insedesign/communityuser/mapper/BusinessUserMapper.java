package com.insedesign.communityuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.insedesign.communityuser.model.entity.BusinessUser;import org.apache.ibatis.annotations.Param;

public interface BusinessUserMapper extends BaseMapper<BusinessUser> {
    BusinessUser selectByUserId(String userId);

    BusinessUser selectByEmail(String email);

    BusinessUser selectByTel(String tel);

    int checkUserId(String userId);

    int checkEmail(String email);

    int checkTel(String tel);

    int offAccount(@Param("operate") Integer operate, @Param("userId") String userId);
}
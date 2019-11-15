package com.insedesign.communityuser.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.communityuser.mapper.BusinessUserMapper;
import com.insedesign.communityuser.model.entity.BusinessUser;
import com.insedesign.communitybuilding.service.BusinessUserService;

@Service
public class BusinessUserServiceImpl extends ServiceImpl<BusinessUserMapper, BusinessUser> implements BusinessUserService {

}






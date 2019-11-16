package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.mapper.BusinessUserMapper;
import com.insedesign.community.service.BusinessUserService;

@Service
public class BusinessUserServiceImpl extends ServiceImpl<BusinessUserMapper, BusinessUser> implements BusinessUserService {

}


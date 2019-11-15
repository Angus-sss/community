package com.insedesign.communitybuilding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.communitybuilding.mapper.BusinessCommunityMapper;
import com.insedesign.communitybuilding.model.entity.BusinessCommunity;
import com.insedesign.communitybuilding.service.BusinessCommunityService;

@Service
public class BusinessCommunityServiceImpl extends ServiceImpl<BusinessCommunityMapper, BusinessCommunity> implements BusinessCommunityService {

}


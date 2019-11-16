package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessCommunityMapper;
import com.insedesign.community.model.entity.BusinessCommunity;
import com.insedesign.community.service.BusinessCommunityService;
@Service
public class BusinessCommunityServiceImpl extends ServiceImpl<BusinessCommunityMapper, BusinessCommunity> implements BusinessCommunityService{

}

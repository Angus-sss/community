package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessCommunityMember;
import com.insedesign.community.mapper.BusinessCommunityMemberMapper;
import com.insedesign.community.service.BusinessCommunityMemberService;
@Service
public class BusinessCommunityMemberServiceImpl extends ServiceImpl<BusinessCommunityMemberMapper, BusinessCommunityMember> implements BusinessCommunityMemberService{

}

package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessUserTagMapper;
import com.insedesign.community.model.entity.BusinessUserTag;
import com.insedesign.community.service.BusinessUserTagService;

@Service
public class BusinessUserTagServiceImpl extends ServiceImpl<BusinessUserTagMapper, BusinessUserTag> implements BusinessUserTagService {

}


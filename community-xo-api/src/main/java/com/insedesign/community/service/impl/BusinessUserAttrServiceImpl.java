package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessUserAttr;
import com.insedesign.community.mapper.BusinessUserAttrMapper;
import com.insedesign.community.service.BusinessUserAttrService;

@Service
public class BusinessUserAttrServiceImpl extends ServiceImpl<BusinessUserAttrMapper, BusinessUserAttr> implements BusinessUserAttrService {

}


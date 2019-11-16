package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessUserLevelMapper;
import com.insedesign.community.model.entity.BusinessUserLevel;
import com.insedesign.community.service.BusinessUserLevelService;

@Service
public class BusinessUserLevelServiceImpl extends ServiceImpl<BusinessUserLevelMapper, BusinessUserLevel> implements BusinessUserLevelService {

}


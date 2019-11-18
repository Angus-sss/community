package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessUserAppeal;
import com.insedesign.community.mapper.BusinessUserAppealMapper;
import com.insedesign.community.service.BusinessUserAppealService;
@Service
public class BusinessUserAppealServiceImpl extends ServiceImpl<BusinessUserAppealMapper, BusinessUserAppeal> implements BusinessUserAppealService{

}

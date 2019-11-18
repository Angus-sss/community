package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessUserCredentials;
import com.insedesign.community.mapper.BusinessUserCredentialsMapper;
import com.insedesign.community.service.BusinessUserCredentialsService;
@Service
public class BusinessUserCredentialsServiceImpl extends ServiceImpl<BusinessUserCredentialsMapper, BusinessUserCredentials> implements BusinessUserCredentialsService{

}

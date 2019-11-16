package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessUserAdmin;
import com.insedesign.community.mapper.BusinessUserAdminMapper;
import com.insedesign.community.service.BusinessUserAdminService;

@Service
public class BusinessUserAdminServiceImpl extends ServiceImpl<BusinessUserAdminMapper, BusinessUserAdmin> implements BusinessUserAdminService {

}


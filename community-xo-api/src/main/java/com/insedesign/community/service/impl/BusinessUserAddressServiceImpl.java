package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessUserAddressMapper;
import com.insedesign.community.model.entity.BusinessUserAddress;
import com.insedesign.community.service.BusinessUserAddressService;

@Service
public class BusinessUserAddressServiceImpl extends ServiceImpl<BusinessUserAddressMapper, BusinessUserAddress> implements BusinessUserAddressService {

}


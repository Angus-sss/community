package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessOwnerCarMapper;
import com.insedesign.community.model.entity.BusinessOwnerCar;
import com.insedesign.community.service.BusinessOwnerCarService;
@Service
public class BusinessOwnerCarServiceImpl extends ServiceImpl<BusinessOwnerCarMapper, BusinessOwnerCar> implements BusinessOwnerCarService{

}

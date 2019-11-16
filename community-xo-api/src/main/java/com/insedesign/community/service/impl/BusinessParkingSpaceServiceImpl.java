package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessParkingSpace;
import com.insedesign.community.mapper.BusinessParkingSpaceMapper;
import com.insedesign.community.service.BusinessParkingSpaceService;
@Service
public class BusinessParkingSpaceServiceImpl extends ServiceImpl<BusinessParkingSpaceMapper, BusinessParkingSpace> implements BusinessParkingSpaceService{

}

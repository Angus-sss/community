package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessBuilding;
import com.insedesign.community.mapper.BusinessBuildingMapper;
import com.insedesign.community.service.BusinessBuildingService;
@Service
public class BusinessBuildingServiceImpl extends ServiceImpl<BusinessBuildingMapper, BusinessBuilding> implements BusinessBuildingService{

}

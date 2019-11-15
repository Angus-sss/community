package com.insedesign.communitybuilding.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.communitybuilding.model.entity.BusinessBuilding;
import com.insedesign.communitybuilding.mapper.BusinessBuildingMapper;
import com.insedesign.communitybuilding.service.BusinessBuildingService;

@Service
public class BusinessBuildingServiceImpl extends ServiceImpl<BusinessBuildingMapper, BusinessBuilding> implements BusinessBuildingService {

}



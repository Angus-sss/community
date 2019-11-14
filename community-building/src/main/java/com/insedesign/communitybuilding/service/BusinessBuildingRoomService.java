package com.insedesign.communitybuilding.service;

import com.insedesign.communitybuilding.model.entity.BusinessBuildingRoom;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BusinessBuildingRoomService extends IService<BusinessBuildingRoom> {


    BusinessBuildingRoom selectByUniId(String unitId);
}





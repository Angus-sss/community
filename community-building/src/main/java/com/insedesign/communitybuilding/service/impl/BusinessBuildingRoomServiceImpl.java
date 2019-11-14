package com.insedesign.communitybuilding.service.impl;

import com.insedesign.communitybuilding.mapper.BusinessBuildingRoomMapper;
import com.insedesign.communitybuilding.model.entity.BusinessBuildingRoom;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.communitybuilding.service.BusinessBuildingRoomService;

import javax.annotation.Resource;

@Service
public class BusinessBuildingRoomServiceImpl extends ServiceImpl<BusinessBuildingRoomMapper, BusinessBuildingRoom> implements BusinessBuildingRoomService {
    @Resource
    BusinessBuildingRoomMapper buildingRoomMapper;

    @Override
    public BusinessBuildingRoom selectByUniId(String unitId) {
        return buildingRoomMapper.selectByUniId(unitId);
    }
}





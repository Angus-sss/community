package com.insedesign.communitybuildingapi.service.impl;

import com.insedesign.communitybuildingapi.mapper.BusinessBuildingRoomMapper;
import com.insedesign.communitybuildingapi.model.entity.BusinessBuildingRoom;
import com.insedesign.communitybuildingapi.service.BuildingRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BuildingRoomServiceImpl implements BuildingRoomService {
    @Resource
    private BusinessBuildingRoomMapper buildingRoomMapper;

    @Override
    public String test(int userId) {
        return "灵霄宝殿";
    }

    @Override
    public BusinessBuildingRoom selectByUserId(int userId) {
        return buildingRoomMapper.selectById(userId);
    }
}
package com.insedesign.communitybuildingapi.service;

import com.insedesign.communitybuildingapi.model.entity.BusinessBuildingRoom;

public interface BuildingRoomService {
    String test(int userId);

    BusinessBuildingRoom selectByUserId(int userId);

}
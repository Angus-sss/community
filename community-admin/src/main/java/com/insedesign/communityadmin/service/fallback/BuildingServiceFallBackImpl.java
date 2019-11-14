package com.insedesign.communityadmin.service.fallback;


import com.insedesign.communityadmin.service.GetBuildingService;
import com.insedesign.communitybuilding.model.entity.BusinessBuildingRoom;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingServiceFallBackImpl implements GetBuildingService {
    String msg = "服务繁忙，先浏览其他页面吧～";


    @Override
    public List<BusinessBuildingRoom> selectList() {
        return null;
    }

    @Override
    public List<BusinessBuildingRoom> selectListPage(int a, int b) {
        return null;
    }

    @Override
    public BusinessBuildingRoom selectByRoomId(String roomId) {
        return null;
    }

    @Override
    public BusinessBuildingRoom selectByUnitId(String unitId) {
        return null;
    }

    @Override
    public BusinessBuildingRoom add(BusinessBuildingRoom buildingRoom) {
        return null;
    }

    @Override
    public String del(String roomId) {
        return null;
    }

    @Override
    public String delList(List<String> roomIds) {
        return null;
    }

    @Override
    public String update() {
        return null;
    }
}

package com.insedesign.communityuserapi.service.fallback;


import com.insedesign.communityuserapi.service.GetBuildingService;
import org.springframework.stereotype.Component;

@Component
public class BuildingServiceFallBackImpl implements GetBuildingService {
    @Override
    public String selectUserBuilding(int userId) {
        return "服务繁忙，先浏览其他页面吧～";
    }
}

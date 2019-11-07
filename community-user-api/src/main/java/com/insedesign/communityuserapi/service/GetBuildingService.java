package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.service.fallback.BuildingServiceFallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:29
 * @Explain:
 */
@FeignClient(value = "community-building-api",fallback = BuildingServiceFallBackImpl.class)
public interface GetBuildingService {
    @GetMapping("se/{userId}")
    String selectUserBuilding(int userId);
}

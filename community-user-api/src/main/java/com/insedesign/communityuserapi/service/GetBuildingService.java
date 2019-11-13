package com.insedesign.communityuserapi.service;

import com.insedesign.communityuserapi.service.fallback.BuildingServiceFallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:29
 * @Explain:
 */
@FeignClient(value = "community-building-api",fallback = BuildingServiceFallBackImpl.class)
public interface GetBuildingService {
    /**
     * 查房
     * @param userId
     * @return
     */
    @GetMapping("se/{userId}")
    String selectUserBuilding(@PathVariable int userId);
}

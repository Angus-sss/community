package com.insedesign.communityadmin.service;

import com.insedesign.communityadmin.service.fallback.BuildingServiceFallBackImpl;
import com.insedesign.communitybuilding.model.entity.BusinessBuildingRoom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:29
 * @Explain:
 */
@FeignClient(value = "community-building-api",fallback = BuildingServiceFallBackImpl.class)
public interface GetBuildingService {
    /**
     * 获取所有方房屋信息
     * @param
     * @return
     */
    @GetMapping("/selectList")
    List<BusinessBuildingRoom> selectList();

    /**
     * 分页查询
     * @param
     * @return
     */
    @GetMapping("/selectListPage/{a}/{b}")
    List<BusinessBuildingRoom> selectListPage(@PathVariable int a, @PathVariable int b);

    /**
     * 根据房屋id查询
     * @param
     * @return
     */
    @GetMapping("/select/{roomId}")
    BusinessBuildingRoom selectByRoomId(@PathVariable String roomId);

    /**
     * 根据单元查询
     * @param
     * @return
     */
    @GetMapping("/selectByUnitId/{unitId}")
    BusinessBuildingRoom selectByUnitId(@PathVariable String unitId);

    /**
     * 添加房屋信息
     * @param
     * @return
     */
    @GetMapping("add/{buildingRoom}")
    BusinessBuildingRoom add(@PathVariable BusinessBuildingRoom buildingRoom);

    /**
     * 删除房屋
     * @param
     * @return
     */
    @GetMapping("del/{roomId}")
    String del(@PathVariable String roomId);

    /**
     * 批量删除
     * @param
     * @return
     */
    @GetMapping("delList/{roomIds}")
    String delList(@PathVariable List<String> roomIds);


    /**
     * 更新信息
     * @param
     * @return
     */
    @GetMapping("")
    String update();
}

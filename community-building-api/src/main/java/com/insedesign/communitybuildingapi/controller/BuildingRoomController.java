package com.insedesign.communitybuildingapi.controller;


import com.insedesign.communitybuildingapi.model.entity.BusinessBuildingRoom;
import com.insedesign.communitybuildingapi.service.BuildingRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author NALHOUG
 */
@RestController
public class BuildingRoomController {
    @Resource
    private BuildingRoomService buildingRoomService;

    /**
     * 获取用户房屋
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "building/{userId}",method = RequestMethod.POST)
    public String test(@PathVariable int userId){
        return buildingRoomService.test(userId);
    }

    /**
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "room/{userId}",method = RequestMethod.POST)
    public BusinessBuildingRoom getRoom(@PathVariable int userId){
        return buildingRoomService.selectByUserId(userId);
    }
}

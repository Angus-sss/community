package com.insedesign.communitybuildingapi.controller;


import com.insedesign.communitybuildingapi.model.entity.BusinessBuildingRoom;
import com.insedesign.communitybuildingapi.service.BuildingRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "building")
public class BuildingRoomController {
    @Resource
    private BuildingRoomService buildingRoomService;

    @ResponseBody
    @RequestMapping(value = "test/{userId}",method = RequestMethod.POST)
    public String test(@PathVariable int userId){
        return buildingRoomService.test(userId);
    }

    @ResponseBody
    @RequestMapping(value = "room/{userId}",method = RequestMethod.POST)
    public BusinessBuildingRoom getRoom(@PathVariable int userId){
        return buildingRoomService.selectByUserId(userId);
    }
}

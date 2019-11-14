package com.insedesign.communitybuildingapi.controller;


import com.insedesign.communitybuildingapi.service.BuildingRoomService;
import com.insedesign.entity.BusinessBuildingRoom;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author NALHOUG
 */
@RestController
public class BuildingRoomController {
    @Resource
    private BuildingRoomService buildingRoomService;

    /**
     * 增加
     * @param buildingRoom
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BusinessBuildingRoom add(BusinessBuildingRoom buildingRoom){
        return buildingRoomService.insert(buildingRoom);
    }
    /**
     * 根据房号找
     * @param roomId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select/{roomId}",method = RequestMethod.POST)
    public BusinessBuildingRoom select(@PathVariable String roomId){
        return buildingRoomService.select(roomId);
    }
    /**
     * 根据单元找
     * @param unitId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectByUnitId/{unitId}",method = RequestMethod.POST)
    public BusinessBuildingRoom selectByUnitId(@PathVariable String unitId){
        return buildingRoomService.select(unitId);
    }
    /**
     * 查询所有
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectList",method = RequestMethod.POST)
    public List<BusinessBuildingRoom> selectList(){
        return buildingRoomService.selectAll();
    }
    /**
     * 分页查询
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select/{a}/{b}",method = RequestMethod.POST)
    public List<BusinessBuildingRoom> selectPage(@PathVariable int a,@PathVariable int b){
        return buildingRoomService.selectPage(a,b);
    }

    /**
     * 单个删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del/{roomId}",method = RequestMethod.POST)
    public int del(@PathVariable String roomId){
        return buildingRoomService.del(roomId);
    }

    /**
     * 批量删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delList/{roomIds}",method = RequestMethod.POST)
    public int delList(@PathVariable List<String> roomIds){
        return buildingRoomService.delList(roomIds);
    }


    /**
     * 批量删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/{buildingRoom}",method = RequestMethod.POST)
    public BusinessBuildingRoom update(@PathVariable BusinessBuildingRoom buildingRoom){
        return buildingRoomService.update(buildingRoom);
    }
}

package com.insedesign.communitybuilding.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.communitybuilding.model.entity.BusinessBuildingRoom;
import com.insedesign.communitybuilding.service.BusinessBuildingRoomService;
import com.insedesign.enmus.Base;
import com.insedesign.enmus.ResultCode;
import com.insedesign.resp.Resp;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author NALHOUG
 */
@RestController
@RequestMapping("/room")
public class BuildingRoomController {
    @Resource
    private BusinessBuildingRoomService service;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessBuildingRoom entity){
        if (service.save(entity)) {
            return Resp.success(service.getById(entity.getRoomId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param roomId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String roomId){
        if (null==roomId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.getById(roomId));
    }
    /**
     * 根据单元找
     * @param unitId
     * @return
     */
    @ResponseBody
    @PostMapping("/selectByUnitId")
    public Resp selectByUnitId(String unitId){
        if (null==unitId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        QueryWrapper<BusinessBuildingRoom> businessBuildingRoomQueryWrapper = new QueryWrapper<>();
        businessBuildingRoomQueryWrapper.eq(BusinessBuildingRoom.COL_UNIT_ID,unitId);
        return Resp.success(service.getOne(businessBuildingRoomQueryWrapper));
    }
    /**
     * 查询所有
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/selectList")
    public Resp selectList(){
        //条件构造器
        QueryWrapper<BusinessBuildingRoom> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingRoom.COL_STATE, Base.IS_OK);
        return Resp.success(service.list(queryWrapper));
    }
    /**
     * 分页查询
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/select/{currentPage}/{pageSize}")
    public Resp selectPage(@PathVariable int currentPage,@PathVariable int pageSize){
        //条件构造器
        QueryWrapper<BusinessBuildingRoom> queryWrapper = new QueryWrapper<>();
        Page<BusinessBuildingRoom> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingRoom.COL_STATE, Base.IS_OK);
        IPage<BusinessBuildingRoom> roomPage = service.page(page,queryWrapper);
        return Resp.success(roomPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> roomIds , HttpServletRequest request){
        return getDel(roomIds);
    }
    @NotNull
    private Resp getDel(List<String> roomIds) {
        QueryWrapper<BusinessBuildingRoom> queryWrapper = new QueryWrapper<>();
        for(String item : roomIds) {
            //查询数据
            BusinessBuildingRoom businessBuildingRoom = service.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessBuildingRoom.COL_ROOM_ID,item);
            service.update(queryWrapper);
        }
        return Resp.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
    public Resp update(BusinessBuildingRoom entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.updateById(entity));
    }
}

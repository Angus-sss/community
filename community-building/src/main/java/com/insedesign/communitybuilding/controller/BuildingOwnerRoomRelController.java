package com.insedesign.communitybuilding.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.communitybuilding.common.enmus.ResultCode;
import com.insedesign.communitybuilding.model.entity.BusinessBuildingOwnerRoomRel;
import com.insedesign.communitybuilding.common.resp.Base;
import com.insedesign.communitybuilding.common.resp.Resp;
import com.insedesign.communitybuilding.service.BusinessBuildingOwnerRoomRelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 14:43
 * @Explain:
 */
@RestController
public class BuildingOwnerRoomRelController {
    @Resource
    private BusinessBuildingOwnerRoomRelService buildingOwnerRoomRelService;

    /**
     * 增加
     * @param buildingOwnerRoomRel
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessBuildingOwnerRoomRel buildingOwnerRoomRel){
        if (buildingOwnerRoomRelService.save(buildingOwnerRoomRel)) {
            return Resp.success(buildingOwnerRoomRelService.getById(buildingOwnerRoomRel.getRoomId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param relId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String relId){
        if (null==relId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(buildingOwnerRoomRelService.getById(relId));
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
        QueryWrapper<BusinessBuildingOwnerRoomRel> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingOwnerRoomRel.COL_STATE, Base.IS_OK);
        return Resp.success(buildingOwnerRoomRelService.list(queryWrapper));
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
        QueryWrapper<BusinessBuildingOwnerRoomRel> queryWrapper = new QueryWrapper<>();
        Page<BusinessBuildingOwnerRoomRel> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingOwnerRoomRel.COL_STATE, Base.IS_OK);
        IPage<BusinessBuildingOwnerRoomRel> relPage = buildingOwnerRoomRelService.page(page,queryWrapper);
        return Resp.success(relPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> relIds , HttpServletRequest request){
        return getDel(relIds);
    }
    @NotNull
    private Resp getDel(List<String> relIds) {
        QueryWrapper<BusinessBuildingOwnerRoomRel> queryWrapper = new QueryWrapper<>();
        for(String item : relIds) {
            //查询数据
            BusinessBuildingOwnerRoomRel businessBuildingRoom = buildingOwnerRoomRelService.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessBuildingOwnerRoomRel.COL_REL_ID,item);
            buildingOwnerRoomRelService.update(queryWrapper);
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
    public Resp update(BusinessBuildingOwnerRoomRel buildingOwnerRoomRel , HttpServletRequest request){
        if (null==buildingOwnerRoomRel){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(buildingOwnerRoomRelService.updateById(buildingOwnerRoomRel));
    }
}

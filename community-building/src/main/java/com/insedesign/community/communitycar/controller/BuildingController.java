package com.insedesign.community.communitycar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessBuilding;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.DateUtil;
import com.insedesign.community.service.BusinessBuildingService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author NALHOUG
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Resource
    private BusinessBuildingService buildingService;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessBuilding entity){
        entity.setBuildingId(Base.BUILDING+DateUtil.getTimeId());
        if (buildingService.save(entity)) {
            return Resp.success(buildingService.getById(entity.getBuildingId()));
        }
        return Resp.error(ResultCode.ERROR);
        //TODO 创建新的对象时后台需要生成对应的 userId  主键id  业务id 等不需要前端传输的值
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
        return Resp.success(buildingService.getById(roomId));
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
        QueryWrapper<BusinessBuilding> businessBuildingBuildingQueryWrapper = new QueryWrapper<>();
        businessBuildingBuildingQueryWrapper.eq(BusinessBuilding.COL_BUILDING_ID,unitId);
        return Resp.success(buildingService.getOne(businessBuildingBuildingQueryWrapper));
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
        QueryWrapper<BusinessBuilding> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuilding.COL_STATE, Base.IS_OK);
        return Resp.success(buildingService.list(queryWrapper));
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
        QueryWrapper<BusinessBuilding> queryWrapper = new QueryWrapper<>();
        Page<BusinessBuilding> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuilding.COL_STATE, Base.IS_OK);
        IPage<BusinessBuilding> roomPage = buildingService.page(page,queryWrapper);
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
        QueryWrapper<BusinessBuilding> queryWrapper = new QueryWrapper<>();
        for(String item : roomIds) {
            //查询数据
            BusinessBuilding businessBuildingBuilding = buildingService.getById(item);
            //设置状态为删除
            businessBuildingBuilding.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessBuilding.COL_BUILDING_ID,item);
            buildingService.update(queryWrapper);
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
    public Resp update(BusinessBuilding entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(buildingService.updateById(entity));
    }
}

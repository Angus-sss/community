package com.insedesign.community.communitycar.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.communitycar.model.entity.BusinessBuildingUnit;
import com.insedesign.community.communitycar.service.BusinessBuildingUnitService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 14:42
 * @Explain:
 */
@RestController
@RequestMapping("/unit")
public class BuildingUnitController {
    @Resource
    private BusinessBuildingUnitService buildingUnitService;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessBuildingUnit entity){

        if (buildingUnitService.save(entity)) {
            return Resp.success(buildingUnitService.getById(entity.getUnitId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param unitId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String unitId){
        if (null==unitId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(buildingUnitService.getById(unitId));
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
        QueryWrapper<BusinessBuildingUnit> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingUnit.COL_STATE, Base.IS_OK);
        return Resp.success(buildingUnitService.list(queryWrapper));
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
        QueryWrapper<BusinessBuildingUnit> queryWrapper = new QueryWrapper<>();
        Page<BusinessBuildingUnit> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingUnit.COL_STATE, Base.IS_OK);
        IPage<BusinessBuildingUnit> unitPage = buildingUnitService.page(page,queryWrapper);
        return Resp.success(unitPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> unitIds , HttpServletRequest request){
        return getDel(unitIds);
    }
    @NotNull
    private Resp getDel(List<String> unitIds) {
        QueryWrapper<BusinessBuildingUnit> queryWrapper = new QueryWrapper<>();
        for(String item : unitIds) {
            //查询数据
            BusinessBuildingUnit entity = buildingUnitService.getById(item);
            //设置状态为删除
            entity.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessBuildingUnit.COL_UNIT_ID,item);
            buildingUnitService.update(queryWrapper);
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
    public Resp update(BusinessBuildingUnit entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(buildingUnitService.updateById(entity));
    }


}

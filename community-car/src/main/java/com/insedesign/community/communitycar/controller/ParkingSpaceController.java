package com.insedesign.community.communitycar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.communitycar.model.entity.BusinessParkingSpace;
import com.insedesign.community.communitycar.service.BusinessParkingSpaceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author NALHOUG
 */
@RestController
@RequestMapping("/space")
public class ParkingSpaceController {
    @Resource
    private BusinessParkingSpaceService service;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessParkingSpace entity){
        if (service.save(entity)) {
            return Resp.success(service.getById(entity.getPsId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param psId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String psId){
        if (null==psId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.getById(psId));
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
        QueryWrapper<BusinessParkingSpace> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessParkingSpace.COL_STATE, Base.IS_OK);
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
        QueryWrapper<BusinessParkingSpace> queryWrapper = new QueryWrapper<>();
        Page<BusinessParkingSpace> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessParkingSpace.COL_STATE, Base.IS_OK);
        IPage<BusinessParkingSpace> carPage = service.page(page,queryWrapper);
        return Resp.success(carPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> psIds , HttpServletRequest request){
        return getDel(psIds);
    }
    @NotNull
    private Resp getDel(List<String> psIds) {
        QueryWrapper<BusinessParkingSpace> queryWrapper = new QueryWrapper<>();
        for(String item : psIds) {
            //查询数据
            BusinessParkingSpace businessBuildingRoom = service.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessParkingSpace.COL_PS_ID,item);
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
    public Resp update(BusinessParkingSpace entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.updateById(entity));
    }
}

package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessOwnerCar;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessOwnerCarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain:
 */
@RestController
@RequestMapping("/credentials")
public class UserAddressController {
    @Resource
    private BusinessOwnerCarService carService;

    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp selectByUserId(String userId){
        if (null==userId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(carService.getById(userId));
    }
    /**
     * 根据id查找
     * @param unitId
     * @return
     */
    @ResponseBody
    @PostMapping("/selectByUnitId")
    public Resp selectByUnitId(String unitId){
        if (null==unitId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        QueryWrapper<BusinessOwnerCar> businessBuildingRoomQueryWrapper = new QueryWrapper<>();
        businessBuildingRoomQueryWrapper.eq(BusinessOwnerCar.COL_CAR_ID,unitId);
        return Resp.success(carService.getOne(businessBuildingRoomQueryWrapper));
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
        QueryWrapper<BusinessOwnerCar> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessOwnerCar.COL_STATE, Base.IS_OK);
        return Resp.success(carService.list(queryWrapper));
    }
    /**
     * 分页查询
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/select/{currentPage}/{pageSize}")
    public Resp selectPage(@PathVariable int currentPage, @PathVariable int pageSize){
        //条件构造器
        QueryWrapper<BusinessOwnerCar> queryWrapper = new QueryWrapper<>();
        Page<BusinessOwnerCar> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessOwnerCar.COL_STATE, Base.IS_OK);
        IPage<BusinessOwnerCar> carPage = carService.page(page,queryWrapper);
        return Resp.success(carPage.getRecords());
    }


    /**
     * 增加
     * @param carId
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp select(String carId){
        if (null==carId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(carService.getById(carId));
    }


    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> carIds , HttpServletRequest request){
        return getDel(carIds);
    }
    @NotNull
    private Resp getDel(List<String> carIds) {
        QueryWrapper<BusinessOwnerCar> queryWrapper = new QueryWrapper<>();
        for(String item : carIds) {
            //查询数据
            BusinessOwnerCar businessBuildingRoom = carService.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessOwnerCar.COL_CAR_ID,item);
            carService.update(queryWrapper);
        }
        return Resp.success();
    }

    /**
     * 修改
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
    public Resp update(BusinessOwnerCar entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(carService.updateById(entity));
    }

}

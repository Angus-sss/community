package com.insedesign.community.communitycar.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessBuildingOwner;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessBuildingOwnerService;
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
@RequestMapping("/owner")
public class BuildingOwnerController {
    @Resource
    private BusinessBuildingOwnerService entityService;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessBuildingOwner entity){

        if (entityService.save(entity)) {
            return Resp.success(entityService.getById(entity.getOwnerId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param ownerId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String ownerId){
        if (null==ownerId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(entityService.getById(ownerId));
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
        QueryWrapper<BusinessBuildingOwner> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingOwner.COL_STATE, Base.IS_OK);
        return Resp.success(entityService.list(queryWrapper));
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
        QueryWrapper<BusinessBuildingOwner> queryWrapper = new QueryWrapper<>();
        Page<BusinessBuildingOwner> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessBuildingOwner.COL_STATE, Base.IS_OK);
        IPage<BusinessBuildingOwner> ownerPage = entityService.page(page,queryWrapper);
        return Resp.success(ownerPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> ownerIds , HttpServletRequest request){
        return getDel(ownerIds);
    }
    @NotNull
    private Resp getDel(List<String> ownerIds) {
        QueryWrapper<BusinessBuildingOwner> queryWrapper = new QueryWrapper<>();
        for(String item : ownerIds) {
            //查询数据
            BusinessBuildingOwner entity = entityService.getById(item);
            //设置状态为删除
            entity.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessBuildingOwner.COL_OWNER_ID,item);
            entityService.update(queryWrapper);
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
    public Resp update(BusinessBuildingOwner entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(entityService.updateById(entity));
    }


}

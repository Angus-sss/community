package com.insedesign.community.communitycar.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.resp.Resp;
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
@RequestMapping("/community")
public class CommunityController {
    @Resource
    private BusinessCommunityService communityService;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessCommunity entity){

        if (communityService.save(entity)) {
            return Resp.success(communityService.getById(entity.getCommunityId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据房号找
     * @param communityId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String communityId){
        if (null==communityId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(communityService.getById(communityId));
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
        QueryWrapper<BusinessCommunity> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessCommunity.COL_STATE, Base.IS_OK);
        return Resp.success(communityService.list(queryWrapper));
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
        QueryWrapper<BusinessCommunity> queryWrapper = new QueryWrapper<>();
        Page<BusinessCommunity> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessCommunity.COL_STATE, Base.IS_OK);
        IPage<BusinessCommunity> communityPage = communityService.page(page,queryWrapper);
        return Resp.success(communityPage.getRecords());
    }

    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> communityIds , HttpServletRequest request){
        return getDel(communityIds);
    }
    @NotNull
    private Resp getDel(List<String> communityIds) {
        QueryWrapper<BusinessCommunity> queryWrapper = new QueryWrapper<>();
        for(String item : communityIds) {
            //查询数据
            BusinessCommunity entity = communityService.getById(item);
            //设置状态为删除
            entity.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessCommunity.COL_COMMUNITY_ID,item);
            communityService.update(queryWrapper);
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
    public Resp update(BusinessCommunity entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(communityService.updateById(entity));
    }


}

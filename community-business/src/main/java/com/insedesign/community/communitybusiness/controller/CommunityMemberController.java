package com.insedesign.community.communitybusiness.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessCommunityMember;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessCommunityMemberService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 14:42
 * @Explain: 小区成员
 */
@RestController
@RequestMapping
public class CommunityMemberController {
    @Resource
    private BusinessCommunityMemberService service;

    /**
     * 增加
     * @param entity
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp add(BusinessCommunityMember entity){

        if (service.save(entity)) {
            return Resp.success(service.getById(entity.getMemberId()));
        }
        return Resp.error(ResultCode.ERROR);
    }
    /**
     * 根据id查找
     * @param ownerId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(String ownerId){
        if (null==ownerId){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.getById(ownerId));
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
        QueryWrapper<BusinessCommunityMember> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessCommunityMember.COL_STATE, Base.IS_OK);
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
        QueryWrapper<BusinessCommunityMember> queryWrapper = new QueryWrapper<>();
        Page<BusinessCommunityMember> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessCommunityMember.COL_STATE, Base.IS_OK);
        IPage<BusinessCommunityMember> ownerPage = service.page(page,queryWrapper);
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
        QueryWrapper<BusinessCommunityMember> queryWrapper = new QueryWrapper<>();
        for(String item : ownerIds) {
            //查询数据
            BusinessCommunityMember entity = service.getById(item);
            //设置状态为删除
            entity.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessCommunityMember.COL_MEMBER_ID,item);
            service.update(queryWrapper);
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
    public Resp update(BusinessCommunityMember entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.updateById(entity));
    }


}

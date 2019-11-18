package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUserAttr;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserAttrService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain: 用户属性 最多记录1条记录
 */
@RestController
@RequestMapping("/credentials")
public class UserAttrController {
    @Resource
    private BusinessUserAttrService service;

    /**
     * 获取当前用户的单个属性信息
     ** @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp selectOne(@NotNull String attrId, HttpSession session){
        QueryWrapper<BusinessUserAttr> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAttr.COL_ATTR_ID,attrId)
                .eq(BusinessUserAttr.COL_USER_ID,thisUser(session).getUserId())
                .eq(BusinessUserAttr.COL_STATE,Base.IS_OK);
        return Resp.success(service.getOne(wrapper));
    }
    /**
     * 获取当前用户的所有属性信息
     ** @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/selectAll")
    public Resp selectByUserId(HttpSession session){
        QueryWrapper<BusinessUserAttr> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAttr.COL_STATE,Base.IS_OK)
                .eq(BusinessUserAttr.COL_USER_ID,thisUser(session).getUserId());
        return Resp.success(service.getOne(wrapper));
    }


    /**
     * 查询所有用户的属性
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/selectList")
    public Resp selectList(){
        //条件构造器
        QueryWrapper<BusinessUserAttr> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessUserAttr.COL_STATE, Base.IS_OK);
        return Resp.success(service.list(queryWrapper));
    }

    /**
     * 增加 属性数量最多存1条
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp select(HttpSession session){
        String userId = thisUser(session).getUserId();
        QueryWrapper<BusinessUserAttr> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAttr.COL_USER_ID,userId);
        //属性最多存5条
        if (Base.DATA_NUM_MAX_1<service.count(wrapper)){
            return Resp.success(service.getById(userId));
        }
        return Resp.error(ResultCode.DATA_MAX_CEILING);
    }
    
    
    /**
     * 删除 按照传入个数进行删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> attrId , HttpServletRequest request){
        return getDel(attrId);
    }
    @NotNull
    private Resp getDel(List<String> attrId) {
        QueryWrapper<BusinessUserAttr> queryWrapper = new QueryWrapper<>();
        for(String item : attrId) {
            //查询数据
            BusinessUserAttr businessBuildingRoom = service.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessUserAttr.COL_ATTR_ID,item);
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
    public Resp update(@NotNull BusinessUserAttr entity , HttpSession session){
        String userId = thisUser(session).getUserId();
        if (userId.equals(entity.getUserId())){
            service.updateById(entity);
            return Resp.success(service.getById(entity));
        }
        return Resp.error(ResultCode.ILLEGAL_OPERATION);
    }
    /**
     * 获取当前用户
     */
    private BusinessUser thisUser(HttpSession session){
        return (BusinessUser)session.getAttribute(Base.THIS_USER);
    }

}

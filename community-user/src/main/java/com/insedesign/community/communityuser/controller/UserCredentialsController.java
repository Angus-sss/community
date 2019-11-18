package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUserCredentials;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserCredentialsService;
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
 * @Explain: 用户证件信息
 * 主要功能：
 * 1. 获取当前信息
 * 2. 修改证件信息
 * 3. 删除证件信息
 * 4. 增加证件信息
 */
@RestController
@RequestMapping("/credentials")
public class UserCredentialsController {
    @Resource
    private BusinessUserCredentialsService service;

    /**
     * 获取当前用户的单个证件信息
     ** @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp selectOne(@NotNull String credentialsId, HttpSession session){
        QueryWrapper<BusinessUserCredentials> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserCredentials.COL_CREDENTIALS_ID,credentialsId)
                .eq(BusinessUserCredentials.COL_USER_ID,thisUser(session).getUserId())
                .eq(BusinessUserCredentials.COL_STATE,Base.IS_OK);
        return Resp.success(service.getOne(wrapper));
    }
    /**
     * 获取当前用户的所有证件信息
     ** @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/selectAll")
    public Resp selectByUserId(HttpSession session){
        QueryWrapper<BusinessUserCredentials> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserCredentials.COL_STATE,Base.IS_OK)
                .eq(BusinessUserCredentials.COL_USER_ID,thisUser(session).getUserId());
        return Resp.success(service.getOne(wrapper));
    }


    /**
     * 查询所有用户的证件
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/selectList")
    public Resp selectList(){
        //条件构造器
        QueryWrapper<BusinessUserCredentials> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessUserCredentials.COL_STATE, Base.IS_OK);
        return Resp.success(service.list(queryWrapper));
    }

    /**
     * 增加 证件数量最多存1条
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp select(HttpSession session){
        String userId = thisUser(session).getUserId();
        QueryWrapper<BusinessUserCredentials> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserCredentials.COL_USER_ID,userId);
        //证件最多存5条
        if (Base.DATA_NUM_MAX_5<service.count(wrapper)){
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
    public Resp delete(List<String> credentialsId , HttpServletRequest request){
        return getDel(credentialsId);
    }
    @NotNull
    private Resp getDel(List<String> credentialsId) {
        QueryWrapper<BusinessUserCredentials> queryWrapper = new QueryWrapper<>();
        for(String item : credentialsId) {
            //查询数据
            BusinessUserCredentials businessBuildingRoom = service.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessUserCredentials.COL_CREDENTIALS_ID,item);
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
    public Resp update(@NotNull BusinessUserCredentials entity , HttpSession session){
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

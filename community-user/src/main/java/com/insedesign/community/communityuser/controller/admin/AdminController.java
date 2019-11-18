package com.insedesign.community.communityuser.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/18 20:59
 * @Explain: 管理员特有权限操作
 * 1. 禁封账号/解封账号
 * 2. 身份认证审核
 * 3. 用户申诉审核
 * 4. 。。。
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private BusinessUserService businessUserService;

    /**
     * 设置用户状态
     * @param userId
     * @param state
     * @return
     */
    @ResponseBody
    @PostMapping("/setUserState")
    public Resp setUserState(@NotNull String userId,@NotNull Integer state){
        BusinessUser user = businessUserService.getById(userId);
        if (Base.ACCOUNT_FORBIDDEN.equals(state)){
            user.setState(state);
        }else if (Base.ACCOUNT_OFF.equals(state)){
            user.setState(state);
        }else if (Base.ACCOUNT_EXCEPTION.equals(state)){
            user.setState(state);
        }else{
            return Resp.error(ResultCode.DATA_IS_WRONG);
        }
        if (businessUserService.save(user)){
            return Resp.success();
        }
        return Resp.error(ResultCode.ERROR);
    }



}

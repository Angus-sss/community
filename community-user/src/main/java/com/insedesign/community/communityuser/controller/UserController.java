package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.vo.AccountVo;
import com.insedesign.community.model.vo.UserVo;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain: 用户中心
 * 主要功能：
 * 获取自己的资料
 * 获取他人的资料
 * 修改自己的资料
 * 注销账户
 *
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private BusinessUserService service;

    /**
     * 查看自己资料
     * @param session
     * @return 
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp select(HttpSession session){
        BusinessUser user = (BusinessUser) session.getAttribute(Base.THIS_USER);
        BusinessUser dbUser = service.getById(user.getUserId());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(dbUser,userVo);
        return Resp.success(userVo);
    }
    /**
     * 查看他人资料
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/selectUser")
    public Resp selectUser(@NotNull String userId){
        BusinessUser dbUser = service.getById(userId);
        if (null!=dbUser){
            AccountVo accountVo = new AccountVo();
            BeanUtils.copyProperties(dbUser,accountVo);
            return Resp.success(accountVo);
        }
        return Resp.error(ResultCode.ACCOUNT_NOT_EXIST);
    }

    /**
     * 注销账户
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/offAccount")
    public Resp offAccount(HttpSession session){
        BusinessUser user = (BusinessUser) session.getAttribute(Base.THIS_USER);
        user.setState(Base.ACCOUNT_FORBIDDEN);
        if (service.updateById(user)){
            return Resp.success();
        }
       return Resp.error(ResultCode.ERROR);
    }

}

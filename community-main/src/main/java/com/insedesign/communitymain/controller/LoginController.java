package com.insedesign.communitymain.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.model.dto.UserLoginDto;
import com.insedesign.community.Md5Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain:
 */
@RestController
public class LoginController {

    @Resource
    BusinessUserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Resp login(UserLoginDto userLoginDto, HttpServletRequest request){
        BusinessUser dbUser = null;
        //判断登录方式 邮箱 手机 用户id 进行数据库查询
        if (Base.EMAIL_REGULAR.matches(userLoginDto.getUsername())){
            QueryWrapper<BusinessUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(BusinessUser.COL_EMAIL,userLoginDto.getUsername());
            dbUser = userService.getOne(queryWrapper);
        }else if (Base.PHONE_REGULAR.matches(userLoginDto.getUsername())){
            QueryWrapper<BusinessUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(BusinessUser.COL_TEL,userLoginDto.getUsername());
            dbUser = userService.getOne(queryWrapper);
        }else {
            dbUser = userService.getById(userLoginDto.getUsername());
        }
        //判断密码是否一致
        if (Md5Utils.encrypt3Times(userLoginDto.getPassword()).equals(dbUser.getPassword())){
            //把用户信息存储到session中
            HttpSession session = request.getSession();
            session.setAttribute(Base.ROLE_USER, dbUser);
            return Resp.success();
            }
        return Resp.success();
    }
}

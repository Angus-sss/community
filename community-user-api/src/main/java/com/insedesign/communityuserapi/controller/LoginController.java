package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.common.utils.Md5Utils;
import com.insedesign.communityuserapi.model.dto.UserLoginDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;
import com.insedesign.communityuserapi.service.BusinessUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain:
 */
@Slf4j
@RestController
@RequestMapping(value = "/welcome")
public class LoginController {

    @Resource
    private BusinessUserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Resp login(UserLoginDto user, HttpServletRequest request) {
        Resp resp = new Resp();
        loginOption(user,resp,request);
        System.out.println(resp.getMsg());
        return resp;
    }
    private void loginOption(UserLoginDto user,Resp resp,HttpServletRequest request){
        BusinessUser dbUser = null;
        String username = user.getName();
        String md5Password = Md5Utils.encrypt3Times(user.getPassword());
        //开始判断登录方式
        if (username.matches(Base.EMAIL_REGULAR)) {
            dbUser = userService.selectByEmail(username);
        }else {
            dbUser = userService.selectByName(username);
        }
        //判断用户是否存在
        if (null==dbUser){
            resp.setResultCode(ResultCode.ACCOUNT_NOT_EXIST);
            return;
        }
        //判断密码是否正确
        if (!md5Password.equals(dbUser.getPassword())){
            resp.setResultCode(ResultCode.LOGIN_PASSWORD_ERROR);
            System.out.println(user.getPassword()+dbUser.getPassword());
            System.out.println(md5Password);
            return;
        }

        HttpSession session = request.getSession();
        //状态正常，存入session
        session.setAttribute(Base.ROLE_USER, dbUser);
        resp.setResultCode(ResultCode.LOGIN_SUCCESS);

    }
}

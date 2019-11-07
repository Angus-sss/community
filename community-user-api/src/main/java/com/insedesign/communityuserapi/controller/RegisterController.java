/*
package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.common.utils.Md5Utils;
import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUser;
import com.insedesign.communityuserapi.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

*/
/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain:
 *//*

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private BusinessUserService userService;
    @Resource
    private BusinessUserTagService userTagService;
    @Resource
    private BusinessUserCredentialsService userCredentialsService;
    @Resource
    private BusinessUserAttrService userAttrService;
    @Resource
    private BusinessUserAddressService userAddressService;

    @ResponseBody
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public Resp register(RegisterUserDto user , HttpServletRequest request){
        Resp resp = new Resp();
        //名字查重
        if (userService.){
            resp.setResultCode(ResultCode.HAS_EXISTED);
            return resp;
        }
        registerNew(user,resp,request);
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public Resp checkUsername(String username, HttpServletRequest request) {
        Resp resp = new Resp();
        BusinessUser dbUser = userService.selectByName(username);
        System.out.println("数据库获取的用户：" +dbUser);
        if (null != dbUser) {
            resp.setResultCode(ResultCode.ACCOUNT_HAS_USERNAME);
            return resp;
        }
        resp.setResultCode(ResultCode.SUCCESS);
        return resp;
    }


    @ResponseBody
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public Resp checkEmail(User user, HttpServletRequest request) {
        Resp resp = new Resp();
        User dbUser = userService.selectByEmail(user.getUsername());
        System.out.println("数据库获取的用户：" +dbUser);
        if (null != dbUser) {
            resp.setResultCode(ResultCode.HAS_EXISTED);
            return resp;
        }
        resp.setResultCode(ResultCode.SUCCESS);
        return resp;
    }


    @ResponseBody
    @RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
    public Resp checkPhone(User user, HttpServletRequest request) {
        System.out.println("后台获取的用户：" + user);
        Resp resp = new Resp();
        User dbUser = userService.selectByPhone(user.getUsername());
        System.out.println("数据库获取的用户：" +dbUser);
        if (null != dbUser) {
            resp.setResultCode(ResultCode.HAS_EXISTED);
            return resp;
        }        resp.setResultCode(ResultCode.SUCCESS);
        return resp;
    }

    private void registerNew( RegisterUserDto user, Resp resp, HttpServletRequest request){
        //Md5加密
        user.setPassword(Md5Utils.encrypt3Times(user.getPassword()));
        //生成注册时间
        user.setCreateTime(new Date());
        System.out.println(user);
        //执行service

        int rSet = userService.(user);

        if (rSet>0){
            resp.setResultCode(ResultCode.ACCOUNT_REGISTER_SUCCESS);
            //获取当前用户id
            Integer userId = userService.selectByUsername(user.getUsername()).getUserId();
            //创建空的图片表
            UserImg userImg = new UserImg();
            userImg.setUserId(userId);
            userImgService.newUserImg(userImg);
            //创建空的信息表
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfoService.newUserInfo(userInfo);

        }else {
            resp.setResultCode(ResultCode.ERROR);
        }
    }

}
*/

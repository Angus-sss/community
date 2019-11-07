/*
package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


*/
/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain:
 *//*

@RestController
@RequestMapping(value = "/user")
public class UserController {
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

    */
/**
     *
     * @param request
     * @return 退出登录
     *//*

    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Resp logout(HttpServletRequest request){
        Resp resp = new Resp();
        System.out.println("当前用户Session："+request.getSession().getAttribute(Base.THIS_USER));
        request.getSession().removeAttribute(Base.THIS_USER);
        resp.setResultCode(ResultCode.LOGOUT_SUCCESS);
        System.out.println("用户注销后："+request.getSession().getAttribute(Base.THIS_USER+request.getSession().getId()));
        return resp;
    }

    */
/**
     *
     * @param request
     * @return 用户信息
     *//*

    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Resp checkInfo(HttpServletRequest request){
        Resp resp = new Resp();
        User sUser = thisAccount(request);
        System.out.println("当前Session用户:"+sUser);
        System.out.println((sUser).getUserId());
        //查询当前用户的详情信息
        sUser.setPassword(null);
        resp.setData(sUser);
        resp.setResultCode(ResultCode.SUCCESS);
        System.out.println(resp);
        return resp;
    }

    */
/**
     *
     * @param request
     * @return 更多资料
     *//*

    @ResponseBody
    @RequestMapping(value = "/more",method = RequestMethod.POST)
    public Resp checkMore(HttpServletRequest request){
        Resp resp = new Resp();
        User sUser = thisAccount(request);
        UserInfo userInfo = userInfoService.selectUserInfo(sUser.getUserId());
        System.out.println(userInfo);
        resp.setData(userInfo);
        return resp;
    }


    */
/**
     *
     * @param user
     * @param request
     * @return 更细资料
     *//*

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp check(User user, HttpServletRequest request){
        Resp resp = new Resp();
        return resp;
    }

    */
/**
     *
     * @param user
     * @param request
     * @return 关闭账户
     *//*

    @ResponseBody
    @RequestMapping(value = "/offUser",method = RequestMethod.POST)
    public Resp offUser(User user, HttpServletRequest request){
        Resp resp = new Resp();
        return resp;
    }

    private User thisAccount(HttpServletRequest request){
        User sUser = (User)request.getSession().getAttribute(Base.THIS_USER);
        return sUser;
    }


    @ResponseBody
    @RequestMapping(value = "/getUserLv",method = RequestMethod.POST)
    public Resp getUserLv(int userId, HttpServletRequest request){
        Resp resp = new Resp();

        resp.setMsg(userLvService.selectUserLv(userId));

        return resp;
    }




}
*/

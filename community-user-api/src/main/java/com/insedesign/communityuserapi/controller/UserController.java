package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.common.utils.GetSessionAccount;
import com.insedesign.communityuserapi.common.utils.Md5Utils;
import com.insedesign.communityuserapi.model.dto.UpdateUserDto;
import com.insedesign.communityuserapi.model.entity.*;
import com.insedesign.communityuserapi.model.vo.UserVo;
import com.insedesign.communityuserapi.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain: 用户中心
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private BusinessUserService userService;
    @Resource
    private GetSessionAccount getSessionAccount;


    /**
     * @Explain 退出登录
     * @param request
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Resp logout(HttpServletRequest request){
        Resp resp = new Resp();
        request.getSession().removeAttribute(Base.THIS_USER);
        resp.setResultCode(ResultCode.LOGOUT_SUCCESS);
        return resp;
    }

    /**
     * @Explain 更改资料
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp update(UpdateUserDto updateUserDto, HttpServletRequest request){
        if (0 < userService.updateUser(updateUserDto)){
            BusinessUser user = userService.selectById(updateUserDto.getId());
            return Resp.success(user);
        }
        return Resp.error(ResultCode.ERROR);
    }

    /**
     * @Explain 注销账户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/off",method = RequestMethod.POST)
    public Resp off(BusinessUser user, HttpServletRequest request){
        BusinessUser dbUser = userService.selectByUserId(getSessionAccount.thisAccount(request).getUserId());
        if (dbUser.getPassword().equals(Md5Utils.encrypt3Times(user.getPassword()))){
            userService.offAccount(user.getUserId());
            return Resp.success();
        }
        return Resp.error(ResultCode.LOGIN_PASSWORD_ERROR);
    }







}

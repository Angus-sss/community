package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.common.resp.Resp;
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
 * @Explain:
 */

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

    /**
     * @Explain 退出登录
     * @param request
     * @return
     */

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

    /**
     * @Explain 查询用户地址
     * @param request
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public Resp checkUserAddress(HttpServletRequest request){
        BusinessUserAddress userAddress = userAddressService.selectByUserId(thisAccount(request).getUserId());
        return Resp.success(userAddress);
    }

    /**
     * @Explain 查询用户订单
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/attr",method = RequestMethod.POST)
    public Resp checkUserAttr(HttpServletRequest request){
        BusinessUserAttr userAttr = userAttrService.selectByUserId(thisAccount(request).getUserId());
        return Resp.success(userAttr);
    }

    /**
     * @Explain 查询用户证件
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/credentials",method = RequestMethod.POST)
    public Resp checkUserCredentials(HttpServletRequest request){
        BusinessUserCredentials userCredentials = userCredentialsService.selectByUserId(thisAccount(request).getUserId());
        return Resp.success(userCredentials);
    }

    /**
     * @Explain 查询用户标签
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/tag",method = RequestMethod.POST)
    public Resp checkUserTag(HttpServletRequest request){
        BusinessUserTag userTag = userTagService.selectByUserId(thisAccount(request).getUserId());
        return Resp.success(userTag);
    }


    /**
     * @Explain 更改资料
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp check(UpdateUserDto updateUserDto, HttpServletRequest request){
        if (0 < userService.updateUser(updateUserDto)){
            BusinessUser user = userService.selectById(updateUserDto.getId());
            return Resp.success(user);
        }
        return Resp.error(ResultCode.ERROR);
    }


    /**
     * @Explain  从Session获取当前用户
     * @param request
     * @return
     */
    private UserVo thisAccount(HttpServletRequest request){
        UserVo user = (UserVo)request.getSession().getAttribute(Base.THIS_USER);
        return user;
    }


}

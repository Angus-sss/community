package com.insedesign.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.communityuser.model.entity.BusinessUser;
import com.insedesign.communityuser.service.BusinessUserService;
import com.insedesign.enmus.ResultCode;
import com.insedesign.model.dto.UserRegisterDto;
import com.insedesign.resp.Resp;
import com.insedesign.utils.Md5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:27
 * @Explain:
 */
@RestController
public class RegisterController {
    @Resource
    BusinessUserService userService;

    /**
     * 注册账号
     * @param registerDto
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public Resp register(UserRegisterDto registerDto, HttpServletRequest request){
        //MD5加密
        registerDto.setPassword(Md5Utils.encrypt3Times(registerDto.getPassword()));
        //转成do
        BusinessUser businessUser = new BusinessUser();
        BeanUtils.copyProperties(registerDto,businessUser);
        //生成注册时间
        businessUser.setCreateTime(new Date());
        userService.save(businessUser);
        return Resp.success();
    }

    /**
     * 检查邮箱
     * @param email
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/checkEmail")
    public Resp checkEmail(String email, HttpServletRequest request){
        QueryWrapper<BusinessUser> businessUserQueryWrapper = new QueryWrapper<>();
        businessUserQueryWrapper.eq(BusinessUser.COL_EMAIL,email);
        if (0<userService.count(businessUserQueryWrapper)){
            return Resp.error(ResultCode.HAS_EXISTED);
        }
        return Resp.success();
    }

    /**
     * 检查用户Id
     * @param userId
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/checkUserId")
    public Resp checkUserId(String userId, HttpServletRequest request){
        QueryWrapper<BusinessUser> businessUserQueryWrapper = new QueryWrapper<>();
        businessUserQueryWrapper.eq(BusinessUser.COL_EMAIL,userId);
        if (0<userService.count(businessUserQueryWrapper)){
            return Resp.error(ResultCode.HAS_EXISTED);
        }
        return Resp.success();
    }

    /**
     * 检查用户手机号码
     * @param tel
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/checkTel")
    public Resp checkTel(String tel, HttpServletRequest request){
        QueryWrapper<BusinessUser> businessUserQueryWrapper = new QueryWrapper<>();
        businessUserQueryWrapper.eq(BusinessUser.COL_TEL,tel);
        if (0<userService.count(businessUserQueryWrapper)){
            return Resp.error(ResultCode.HAS_EXISTED);
        }
        return Resp.success();
    }


}

package com.insedesign.communitymain.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.utils.DateUtil;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.*;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.model.dto.UserRegisterDto;
import com.insedesign.community.utils.Md5Utils;
import com.insedesign.community.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:27
 * @Explain:
 */
@Slf4j
@RestController
public class RegisterController {
    @Resource
    BusinessUserService userService;
    @Resource
    BusinessUserCredentialsService userCredentialsService;
    @Resource
    BusinessUserAddressService userAddressService;
    @Resource
    BusinessUserAttrService userAttrService;
    @Resource
    BusinessUserTagService userTagService;
    @Resource
    BusinessUserLevelService userLevelService;


    /**
     * 注册账号
     * @param registerDto
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public Resp register(@Valid @RequestBody UserRegisterDto registerDto, HttpServletRequest request){
        //MD5加密
        registerDto.setPassword(Md5Utils.encrypt3Times(registerDto.getPassword()));
        //转成do
        BusinessUser businessUser = new BusinessUser();
        BeanUtils.copyProperties(registerDto,businessUser);
        //生成注册时间
        businessUser.setCreateTime(new Date());
        if (userService.save(businessUser)){

            /**
             * 生成关联字段
             * TODO  这里的方法可能不规范，可以不用生成，不必要的字段可以使用懒创建，当用户需要添加的时候再添加关联，比这个方法好
             * TODO  方法已注释
             */
            String userId = registerDto.getUserId();
            //地址
            BusinessUserAddress address = new BusinessUserAddress();
            address.setAddressId(Base.U_ADDRESS+DateUtil.getTimeId());
            address.setUserId(userId);
            boolean addressState = userAddressService.save(address);
            //属性
            BusinessUserAttr attr = new BusinessUserAttr();
            attr.setAttrId(Base.U_ATTR+DateUtil.getTimeId());
            attr.setUserId(userId);
            boolean attrState = userAttrService.save(attr);
            //表签
            BusinessUserTag tag = new BusinessUserTag();
            tag.setTagId(Base.U_TAG+DateUtil.getTimeId());
            tag.setUserId(userId);
            boolean tagState = userTagService.save(tag);
            //证件
            BusinessUserCredentials credentials = new BusinessUserCredentials();
            credentials.setCredentialsId(Base.U_CRED+DateUtil.getTimeId());
            credentials.setUserId(userId);
            boolean credState = userCredentialsService.save(credentials);
            //用户经验
            BusinessUserLevel level =new BusinessUserLevel();
            level.setLevelId(Base.U_LEVEL+DateUtil.getTimeId());
            level.setUserId(userId);
            boolean levelState = userLevelService.save(level);
            log.info("关联用户地址："+addressState+",关联用户属性："+attrState+",关联用户标签"+tag+",用户证件"+credState+",用户经验"+levelState);
        }
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

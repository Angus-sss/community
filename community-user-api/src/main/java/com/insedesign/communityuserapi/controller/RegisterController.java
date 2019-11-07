package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.model.dto.RegisterUserDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;
import com.insedesign.communityuserapi.model.entity.BusinessUserAttr;
import com.insedesign.communityuserapi.model.entity.BusinessUserCredentials;
import com.insedesign.communityuserapi.model.entity.BusinessUserTag;
import com.insedesign.communityuserapi.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain:
 */

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
    public Resp register(RegisterUserDto userDto , HttpServletRequest request){
        Resp resp = new Resp();
        //名字查重
        if (0 < userService.checkName(userDto.getName())){
            resp.setResultCode(ResultCode.HAS_EXISTED);
            return resp;
        }
        //根据影响行数做进一步处理
        if (0==userService.insert(userDto)) {
            resp.setResultCode(ResultCode.ACCOUNT_REGISTER_ERROR);
            return resp;
        }
        //获取当前用户id
        String userId = userService.selectByName(userDto.getName()).getUserId();

        //创建关联数据
        BusinessUserAddress newUserAddress = new BusinessUserAddress();
        newUserAddress.setUserId(userId);
        userAddressService.insert(newUserAddress);

        BusinessUserAttr newUserAttr = new BusinessUserAttr();
        newUserAddress.setUserId(userId);
        userAttrService.insert(newUserAttr);

        BusinessUserCredentials newUserCredentials = new BusinessUserCredentials();
        newUserAddress.setUserId(userId);
        userCredentialsService.insert(newUserCredentials);

        BusinessUserTag newUserTag = new BusinessUserTag();
        newUserTag.setUserId(userId);
        userTagService.insert(newUserTag);

        resp.setResultCode(ResultCode.ACCOUNT_REGISTER_SUCCESS);
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public Resp checkUsername(String username, HttpServletRequest request) {
        Resp resp = new Resp();
        if (0 < userService.checkName(username)) {
            resp.setResultCode(ResultCode.ACCOUNT_HAS_USERNAME);
            return resp;
        }
        resp.setResultCode(ResultCode.SUCCESS);
        return resp;
    }


    @ResponseBody
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public Resp checkEmail(String email, HttpServletRequest request) {
        Resp resp = new Resp();
        if (0 < userService.checkEmail(email)) {
            resp.setResultCode(ResultCode.HAS_EXISTED);
            return resp;
        }
        resp.setResultCode(ResultCode.SUCCESS);
        return resp;
    }



}

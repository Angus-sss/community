package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.service.BusinessUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain: 账号申诉入口
 */
@RestController
@RequestMapping(value = "/appeal ")
public class AppealController {

    @Resource
    private BusinessUserService userService;
    /**
     * 忘记密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pwd",method = RequestMethod.POST)
    public Resp forgotPwd(){
        return new Resp();
    }

    /**
     * 申诉账号
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public Resp appealAccount(){
        return new Resp();
    }


}

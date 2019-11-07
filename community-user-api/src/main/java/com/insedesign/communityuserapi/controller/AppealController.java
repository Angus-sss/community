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
 * @Explain:
 */
@RestController
@RequestMapping(value = "/appeal ")
public class AppealController {
    @Resource
    private BusinessUserService userService;



    @ResponseBody
    @RequestMapping(value = "/pwd",method = RequestMethod.POST)
    public Resp forgotPwd(){
        Resp resp = new Resp();
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public Resp appealAccount(){
        Resp resp = new Resp();
        return resp;
    }


}

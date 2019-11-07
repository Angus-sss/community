package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.service.BusinessUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain:
 */
@RestController
@RequestMapping(value = "/password")
public class PasswordController {
    @Resource
    private BusinessUserService userService;

    public Resp retrieve(){
        Resp resp = new Resp();
        return resp;
    }


}

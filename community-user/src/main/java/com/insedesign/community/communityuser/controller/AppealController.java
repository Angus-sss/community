package com.insedesign.community.communityuser.controller;

import com.insedesign.community.resp.Resp;
import com.insedesign.community.communityuser.service.BusinessUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain: 账号申诉入口
 */
@RestController
public class AppealController {

    @Resource
    private BusinessUserService userService;
    /**
     * 忘记密码
     * @return
     */
    @ResponseBody
    @PostMapping("/pwd")
    public Resp forgotPwd(){
        return new Resp();
    }

    /**
     * 申诉账号
     * @return
     */
    @ResponseBody
    @PostMapping("/account")
    public Resp appealAccount(){
        return new Resp();
    }


}
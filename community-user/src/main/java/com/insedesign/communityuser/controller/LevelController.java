package com.insedesign.communityuser.controller;

import com.insedesign.communityuser.model.entity.BusinessUserLevel;
import com.insedesign.resp.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 20:09
 * @Explain: 用户等级经验接口
 */
@RestController
@RequestMapping("/lv")
public class LevelController {

    @PostMapping("add")
    public Resp add(BusinessUserLevel businessUserLevel){
        return Resp.success();
    }

}

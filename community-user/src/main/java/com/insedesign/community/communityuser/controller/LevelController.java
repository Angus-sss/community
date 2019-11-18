package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUserLevel;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserLevelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 20:09
 * @Explain: 用户等级经验接口
 */
@RestController
@RequestMapping("/lv")
public class LevelController {
    @Resource
    BusinessUserLevelService service;

    /**
     * 增加用户等级对象
     * @param businessUserLevel
     * @return
     */
    @PostMapping("/add")
    public Resp add(BusinessUserLevel businessUserLevel){
        QueryWrapper<BusinessUserLevel> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserLevel.COL_USER_ID,businessUserLevel.getUserId());
        if(0<service.count(wrapper)){
            return Resp.error(ResultCode.DATA_IS_HAS);
        }
        if (service.save(businessUserLevel)){
            return Resp.success();
        }
        return Resp.error(ResultCode.ERROR);

    }

    /**
     * 增加用户经验
     * @param userId 用户Id
     * @param exp 经验值
     * @return
     */
    @PostMapping("/addExp")
    public Resp addExp(String userId,Integer exp){
        return Resp.error(ResultCode.ERROR);

    }
    /**
     * 查询经验值
     * @param userId
     * @return
     */
    @PostMapping("/getExp")
    public Resp getExp(String userId){
        QueryWrapper<BusinessUserLevel> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserLevel.COL_USER_ID,userId);
        return Resp.success(service.getOne(wrapper).getExp());
    }

}

package com.insedesign.communitymain.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUserAppeal;
import com.insedesign.community.service.BusinessUserAppealService;
import com.insedesign.community.service.BusinessUserService;
import com.insedesign.community.utils.Md5Utils;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.dto.AppealDto;
import com.insedesign.community.resp.Resp;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:46
 * @Explain: 账号申诉入口
 */
@RestController
@RequestMapping("/appeal")
public class AppealController {
    @Resource
    private BusinessUserService userService;
    @Resource
    private BusinessUserAppealService userAppealService;
    /**
     * 忘记密码
     * 通过邮箱验证 修改密码 /暂时省略邮箱验证码验证
     * 再验证邮箱号码是否存在
     * 如果存在则发送验证码至邮箱
     * 验证验证码
     * 获取数据中的新密码，修改密码
     * @param email 邮箱
     * @return
     */
    @ResponseBody
    @PostMapping("/pwd")
    public Resp forgotPwd(String email){
        QueryWrapper<BusinessUser> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUser.COL_EMAIL,email);
        if (0<userService.count(wrapper)){
            //TODO 调用邮件服务器  设置Redis的验证码发送时隔
            return Resp.success();
        }
        return Resp.error(ResultCode.ACCOUNT_NOT_EXIST);
    }
    @ResponseBody
    @PostMapping("/newPwd")
    public Resp setNewPwd(AppealDto appealDto){
        //TODO 获取短信服务的验证码
        //伪验证码
        String code = "1234";
        if (code.equals(appealDto.getVerificationCode())){
            QueryWrapper<BusinessUser> wrapper = new QueryWrapper<>();
            wrapper.eq(BusinessUser.COL_PASSWORD,Md5Utils.encrypt3Times(appealDto.getNewPassword()));
            if (userService.update(wrapper)){
                return Resp.success();
            }
            return Resp.error(ResultCode.DATA_IS_WRONG);
        }
        return Resp.error(ResultCode.VERIFICATION_CODE_ERROR);
    }

    /**
     * 申诉账号
     * 流程：人工审核
     * 提交时默认设置为审核状态
     * 7天内没有人审核 默认设置为失败
     * @param userAppeal 申诉信息
     * @return
     */
    @ResponseBody
    @PostMapping("/getInfo")
    public Resp appealAccount(BusinessUserAppeal userAppeal){
        QueryWrapper<BusinessUserAppeal> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAppeal.COL_USER_ID,userAppeal.getUserId());
        if (0<userAppealService.count(wrapper)){
            if (userAppealService.save(userAppeal)){
                return Resp.success(ResultCode.SUBMIT_AUDIT);
            }
        }
        return Resp.error(ResultCode.ERROR);
    }

}
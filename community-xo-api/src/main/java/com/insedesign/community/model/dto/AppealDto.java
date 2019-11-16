package com.insedesign.community.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/16 17:40
 * @Explain:
 */
@Data
public class AppealDto {
    /**
     * 用户id
     */
    @NotNull
    private String userId;
    /**
     * 用户邮箱
     */
    @NotNull
    private String credentials;

    @NotNull
    @Email
    private String email;
    /**
     * 新密码
     */
    @NotNull
    private String newPassword;

    /**
     * 验证码
     */
    @NotNull
    private String verificationCode;



}

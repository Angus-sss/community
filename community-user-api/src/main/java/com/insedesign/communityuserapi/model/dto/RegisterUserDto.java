package com.insedesign.communityuserapi.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:52
 * @Explain:
 */
@Data
public class RegisterUserDto {

    /**
     * 用户ID
     */
    @NotNull
    private String userId;
    /**
     * 业务Id
     */
    private String bId;
    /**
     * 邮箱地址
     */
    @NotNull
    @Email
    private String email;

    /**
     * 用户密码
     */
    @NotNull
    private String password;


    /**
     * 电话，不能为空
     */
    @NotNull
    private String tel;

    /**
     * 姓名
     */
    @NotNull
    private String name;

}

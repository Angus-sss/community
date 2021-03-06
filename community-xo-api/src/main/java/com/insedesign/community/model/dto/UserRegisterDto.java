package com.insedesign.community.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:52
 * @Explain:
 */
@Data
public class UserRegisterDto {
    public static final String COL_ID = "id";
    /**
     * 用户ID
     */
    @NotNull
    private String userId;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    @NotNull
    private String email;

    /**
     * 现居住地址
     */
    private String address;

    /**
     * 用户密码
     */
    @NotNull
    private String password;

    /**
     * 用户地区
     */
    private String locationCd;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 性别，0表示男孩 1表示女孩
     */
    private String sex;

    /**
     * 电话
     */
    private String tel;



}

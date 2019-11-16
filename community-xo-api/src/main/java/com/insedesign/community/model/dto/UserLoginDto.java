package com.insedesign.community.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:53
 * @Explain:
 */
@Data
public class UserLoginDto {
    /**
     *统一入口
     */
    @NotNull
    private String username;

    /**
     * 用户密码，加密过后
     */
    @NotNull
    private String password;
}

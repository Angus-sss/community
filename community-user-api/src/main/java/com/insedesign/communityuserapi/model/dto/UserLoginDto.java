package com.insedesign.communityuserapi.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
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
     * 用户ID
     */
    private String userId;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 用户密码，加密过后
     */
    @NotNull
    private String password;

}

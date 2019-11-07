package com.insedesign.communityuserapi.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:52
 * @Explain:
 */
@Data
public class RegisterUserDto {
    /**
     * 名称
     */
    @NotNull
    private String name;

    /**
     * 邮箱地址
     */
    @NotNull
    @Email
    private String email;

    /**
     * 现居住地址
     */
    private String address;

    /**
     * 用户密码，加密过后
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
     * 创建时间
     */
    @Null
    private Date createTime;

}

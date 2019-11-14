package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessUser {
    /**
    * id
    */
    private Integer id;

    /**
    * 业务Id
    */
    private String bId;

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
    * 现居住地址
    */
    private String address;

    /**
    * 用户密码，加密过后
    */
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

    private String tel;

    /**
    * 用户级别,关联user_level
    */
    private String levelCd;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 1为正常，2为销户，3为异常
    */
    private Integer operate;
}
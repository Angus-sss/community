package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user")
public class BusinessUser implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 暂时为管理员ADMIN 普通用户USER 关联admin表
     */
    @TableField(value = "user_status")
    private String userStatus;

    /**
     * 邮箱地址
     */
    @TableField(value = "email")
    private String email;

    /**
     * 现居住地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 用户密码，加密过后
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户地区
     */
    @TableField(value = "location_cd")
    private String locationCd;

    /**
     * 用户年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 性别，0表示男孩 1表示女孩
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 电话
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 用户等级，根据经验后台判断等级
     */
    @TableField(value = "level")
    private String level;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 最后一次登录
     */
    @TableField(value = "last_login")
    private Date lastLogin;

    /**
     * 特殊状态
     */
    @TableField(value = "operate")
    private String operate;

    /**
     * 1为正常，2为销户，3为异常 0为删除
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_NAME = "name";

    public static final String COL_USER_STATUS = "user_status";

    public static final String COL_EMAIL = "email";

    public static final String COL_ADDRESS = "address";

    public static final String COL_PASSWORD = "password";

    public static final String COL_LOCATION_CD = "location_cd";

    public static final String COL_AGE = "age";

    public static final String COL_SEX = "sex";

    public static final String COL_TEL = "tel";

    public static final String COL_LEVEL = "level";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_LAST_LOGIN = "last_login";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
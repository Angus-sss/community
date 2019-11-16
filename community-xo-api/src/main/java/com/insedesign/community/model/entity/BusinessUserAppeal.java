package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user_appeal")
public class BusinessUserAppeal implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 用户号码
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 证件号码
     */
    @TableField(value = "credentials")
    private String credentials;

    /**
     * 申诉说明
     */
    @TableField(value = "explain")
    private String explain;

    /**
     * 历史密码1
     */
    @TableField(value = "password_a")
    private String passwordA;

    /**
     * 注册地址
     */
    @TableField(value = "register_address")
    private String registerAddress;

    /**
     * 历史密码2
     */
    @TableField(value = "password_b")
    private String passwordB;

    /**
     * 注册时间
     */
    @TableField(value = "register_time")
    private String registerTime;

    /**
     * 申诉创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 历史密码3
     */
    @TableField(value = "password_c")
    private String passwordC;

    /**
     * 审核状态 NOT为审核失败  ING为正在审核  WIIN为审核通过
     */
    @TableField(value = "audit")
    private String audit;

    /**
     * 1为存在  0为删除
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_EMAIL = "email";

    public static final String COL_TEL = "tel";

    public static final String COL_CREDENTIALS = "credentials";

    public static final String COL_EXPLAIN = "explain";

    public static final String COL_PASSWORD_A = "password_a";

    public static final String COL_REGISTER_ADDRESS = "register_address";

    public static final String COL_PASSWORD_B = "password_b";

    public static final String COL_REGISTER_TIME = "register_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_PASSWORD_C = "password_c";

    public static final String COL_AUDIT = "audit";

    public static final String COL_STATE = "state";
}
package com.insedesign.communityuserapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user")
public class BusinessUser {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

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

    @TableField(value = "tel")
    private String tel;

    /**
     * 用户级别,关联user_level
     */
    @TableField(value = "level_cd")
    private String levelCd;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    @TableField(value = "operate")
    private String operate;

    public static final String COL_ID = "id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_NAME = "name";

    public static final String COL_EMAIL = "email";

    public static final String COL_ADDRESS = "address";

    public static final String COL_PASSWORD = "password";

    public static final String COL_LOCATION_CD = "location_cd";

    public static final String COL_AGE = "age";

    public static final String COL_SEX = "sex";

    public static final String COL_TEL = "tel";

    public static final String COL_LEVEL_CD = "level_cd";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";
}
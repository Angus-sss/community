package com.insedesign.communityuser.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user_address")
public class BusinessUserAddress implements Serializable {
    /**
     * 地址ID
     */
    @TableId(value = "address_id", type = IdType.INPUT)
    private String addressId;

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
     * 电话
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 邮政编码
     */
    @TableField(value = "postal_code")
    private String postalCode;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 是否为默认地址 1，表示默认地址 0 或空不是默认地址
     */
    @TableField(value = "is_default")
    private String isDefault;

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

    /**
     * 0为删除 1为存在
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ADDRESS_ID = "address_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TEL = "tel";

    public static final String COL_POSTAL_CODE = "postal_code";

    public static final String COL_ADDRESS = "address";

    public static final String COL_IS_DEFAULT = "is_default";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
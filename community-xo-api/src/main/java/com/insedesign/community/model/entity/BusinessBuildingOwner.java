package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building_owner")
public class BusinessBuildingOwner implements Serializable {
    /**
     * 业主ID
     */
    @TableId(value = "owner_id", type = IdType.INPUT)
    private String ownerId;

    /**
     * 业主成员ID
     */
    @TableField(value = "member_id")
    private String memberId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 业主名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 联系人手机号
     */
    @TableField(value = "link")
    private String link;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 业主状态
     */
    @TableField(value = "operate")
    private String operate;

    /**
     * 1001 业主本人 1002 家庭成员
     */
    @TableField(value = "owner_type_cd")
    private String ownerTypeCd;

    /**
     * 0为 删除  1为存在
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_OWNER_ID = "owner_id";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_NAME = "name";

    public static final String COL_SEX = "sex";

    public static final String COL_AGE = "age";

    public static final String COL_LINK = "link";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_OWNER_TYPE_CD = "owner_type_cd";

    public static final String COL_STATE = "state";
}
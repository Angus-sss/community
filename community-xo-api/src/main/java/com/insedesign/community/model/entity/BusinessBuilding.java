package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building")
public class BusinessBuilding implements Serializable {
    /**
     * 楼房ID
     */
    @TableId(value = "building_id", type = IdType.INPUT)
    private String buildingId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 用户Id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 楼名
     */
    @TableField(value = "building_name")
    private String buildingName;

    /**
     * 单元数
     */
    @TableField(value = "units")
    private String units;

    /**
     * 楼层数
     */
    @TableField(value = "floors")
    private Integer floors;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 备注
     */
    @TableField(value = "remake")
    private String remake;

    /**
     * 楼层状态
     */
    @TableField(value = "operate")
    private String operate;

    /**
     * 0为删除 1为存在
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_BUILDING_ID = "building_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_BUILDING_NAME = "building_name";

    public static final String COL_UNITS = "units";

    public static final String COL_FLOORS = "floors";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_REMAKE = "remake";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
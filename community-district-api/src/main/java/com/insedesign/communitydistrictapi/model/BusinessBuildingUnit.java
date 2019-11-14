package com.insedesign.communitydistrictapi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building_unit")
public class BusinessBuildingUnit {
    /**
     * 单元ID
     */
    @TableField(value = "unit_id")
    private String unitId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 单元编号
     */
    @TableField(value = "unit_num")
    private String unitNum;

    /**
     * 楼ID
     */
    @TableField(value = "floor_id")
    private String floorId;

    /**
     * 总层数
     */
    @TableField(value = "layer_count")
    private Integer layerCount;

    /**
     * 是否有电梯 1010有 2020 无
     */
    @TableField(value = "lift")
    private String lift;

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
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    @TableField(value = "operate")
    private String operate;

    public static final String COL_UNIT_ID = "unit_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_UNIT_NUM = "unit_num";

    public static final String COL_FLOOR_ID = "floor_id";

    public static final String COL_LAYER_COUNT = "layer_count";

    public static final String COL_LIFT = "lift";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";
}
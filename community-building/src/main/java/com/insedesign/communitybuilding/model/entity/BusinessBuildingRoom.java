package com.insedesign.communitybuilding.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building_room")
public class BusinessBuildingRoom {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房屋ID
     */
    @TableField(value = "room_id")
    private String roomId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 房屋编号
     */
    @TableField(value = "room_num")
    private String roomNum;

    /**
     * 单元ID
     */
    @TableField(value = "unit_id")
    private String unitId;

    /**
     * 层数
     */
    @TableField(value = "layer")
    private Integer layer;

    /**
     * 室
     */
    @TableField(value = "section")
    private Integer section;

    /**
     * 户型
     */
    @TableField(value = "apartment")
    private String apartment;

    /**
     * 建筑面积
     */
    @TableField(value = "built_up_area")
    private BigDecimal builtUpArea;

    /**
     * 每平米单价
     */
    @TableField(value = "unit_price")
    private BigDecimal unitPrice;

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

    /**
     * 房屋状态，如房屋出售等，请查看state 表
     */
    @TableField(value = "state")
    private Integer state;

    public static final String COL_ID = "id";

    public static final String COL_ROOM_ID = "room_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_ROOM_NUM = "room_num";

    public static final String COL_UNIT_ID = "unit_id";

    public static final String COL_LAYER = "layer";

    public static final String COL_SECTION = "section";

    public static final String COL_APARTMENT = "apartment";

    public static final String COL_BUILT_UP_AREA = "built_up_area";

    public static final String COL_UNIT_PRICE = "unit_price";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
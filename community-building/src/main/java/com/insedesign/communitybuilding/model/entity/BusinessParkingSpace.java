package com.insedesign.communitybuilding.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author NALHOUG
 */
@Data
@TableName(value = "business_parking_space")
public class BusinessParkingSpace implements Serializable {
    /**
     * 车位ID
     */
    @TableId(value = "ps_id", type = IdType.INPUT)
    private String psId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 小区ID
     */
    @TableField(value = "community_id")
    private String communityId;

    /**
     * 车位编号
     */
    @TableField(value = "num")
    private String num;

    /**
     * 车位类型,地上停车位1001 地下停车位 2001
     */
    @TableField(value = "type_cd")
    private String typeCd;

    /**
     * 车位状态 出售 SELL，出租 RENT ，空闲 FREE
     */
    @TableField(value = "ps_state")
    private String psState;

    /**
     * 车位面积
     */
    @TableField(value = "area")
    private BigDecimal area;

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
     * 1为存在 0为删除
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_PS_ID = "ps_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_COMMUNITY_ID = "community_id";

    public static final String COL_NUM = "num";

    public static final String COL_TYPE_CD = "type_cd";

    public static final String COL_PS_STATE = "ps_state";

    public static final String COL_AREA = "area";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
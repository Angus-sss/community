package com.insedesign.communitybuilding.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_owner_car")
public class BusinessOwnerCar implements Serializable {
    /**
     * 汽车ID
     */
    @TableField(value = "car_id")
    private String carId;

    /**
     * 业主ID
     */
    @TableField(value = "owner_id")
    private String ownerId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 车牌号
     */
    @TableField(value = "car_num")
    private String carNum;

    /**
     * 汽车品牌
     */
    @TableField(value = "car_brand")
    private String carBrand;

    /**
     * 9901 家用小汽车，9902 客车，9903 货车
     */
    @TableField(value = "car_type")
    private String carType;

    /**
     * 颜色
     */
    @TableField(value = "car_color")
    private String carColor;

    /**
     * 车位ID
     */
    @TableField(value = "ps_id")
    private String psId;

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
     * 0 为删除 1为正常
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_CAR_ID = "car_id";

    public static final String COL_OWNER_ID = "owner_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_CAR_NUM = "car_num";

    public static final String COL_CAR_BRAND = "car_brand";

    public static final String COL_CAR_TYPE = "car_type";

    public static final String COL_CAR_COLOR = "car_color";

    public static final String COL_PS_ID = "ps_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
package com.insedesign.communitybuilding.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_community")
public class BusinessCommunity {
    /**
     * 小区ID
     */
    @TableId(value = "community_id", type = IdType.AUTO)
    private Integer communityId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 小区名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 小区地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 根据定位获取城市编码
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 地标，如王府井北60米
     */
    @TableField(value = "nearby_landmarks")
    private String nearbyLandmarks;

    /**
     * 地区 x坐标
     */
    @TableField(value = "map_x")
    private String mapX;

    /**
     * 地区 y坐标
     */
    @TableField(value = "map_y")
    private String mapY;

    /**
     * 月份
     */
    @TableField(value = "month")
    private Integer month;

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

    public static final String COL_COMMUNITY_ID = "community_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_NAME = "name";

    public static final String COL_ADDRESS = "address";

    public static final String COL_CITY_CODE = "city_code";

    public static final String COL_NEARBY_LANDMARKS = "nearby_landmarks";

    public static final String COL_MAP_X = "map_x";

    public static final String COL_MAP_Y = "map_y";

    public static final String COL_MONTH = "month";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";
}
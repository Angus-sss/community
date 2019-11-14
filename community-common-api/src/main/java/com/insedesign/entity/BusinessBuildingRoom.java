package com.insedesign.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class BusinessBuildingRoom {
    /**
    * 房屋ID
    */
    private String roomId;

    /**
    * 业务Id
    */
    private String bId;

    /**
    * 房屋编号
    */
    private String roomNum;

    /**
    * 单元ID
    */
    private String unitId;

    /**
    * 层数
    */
    private Integer layer;

    /**
    * 室
    */
    private Integer section;

    /**
    * 户型
    */
    private String apartment;

    /**
    * 建筑面积
    */
    private BigDecimal builtUpArea;

    /**
    * 每平米单价
    */
    private BigDecimal unitPrice;

    /**
    * 用户ID
    */
    private String userId;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;

    /**
    * 房屋状态，如房屋出售等，请查看state 表
    */
    private String state;
}
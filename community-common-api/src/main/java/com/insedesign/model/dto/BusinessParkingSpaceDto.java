package com.insedesign.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author NALHOUG
 */
@Data
public class BusinessParkingSpaceDto implements Serializable {
    /**
     * 车位ID
     */
    private String psId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 车位编号
     */
    private String num;

    /**
     * 车位类型,地上停车位1001 地下停车位 2001
     */
    private String typeCd;

    /**
     * 车位状态 出售 SELL，出租 RENT ，空闲 FREE
     */
    private String psState;

    /**
     * 车位面积
     */
    private BigDecimal area;

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

}
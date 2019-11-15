package com.insedesign.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author NALHOUG
 */
@Data
public class BusinessBuildingRoomDto implements Serializable {
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
     * 备注
     */
    private String remark;


}
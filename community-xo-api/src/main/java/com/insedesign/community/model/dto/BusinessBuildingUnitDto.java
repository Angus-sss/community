package com.insedesign.community.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NALHOUG
 */
@Data
public class BusinessBuildingUnitDto implements Serializable {

    /**
     * 单元编号
     */
    private String unitNum;

    /**
     * 楼ID
     */
    private String floorId;

    /**
     * 总层数
     */
    private Integer layerCount;

    /**
     * 是否有电梯 1010有 2020 无
     */
    private String lift;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 备注
     */
    private String remark;


}
package com.insedesign.model.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author NALHOUG
 */
@Data
public class BusinessBuildingDto implements Serializable {
    /**
     * 业务Id
     */
    private String bId;

    /**
     * 楼名
     */
    private String buildingName;

    /**
     * 单元数
     */
    private String units;

    /**
     * 楼层数
     */
    private Integer floors;

    /**
     * 备注
     */
    private String remake;

    /**
     * 楼层状态
     */
    private String operate;



}
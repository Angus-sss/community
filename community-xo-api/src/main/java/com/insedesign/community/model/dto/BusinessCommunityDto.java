package com.insedesign.community.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NALHOUG
 */
@Data
public class BusinessCommunityDto implements Serializable {
    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 小区名称
     */
    private String name;

    /**
     * 小区地址
     */
    private String address;

    /**
     * 根据定位获取城市编码
     */
    private String cityCode;

    /**
     * 地标，如王府井北60米
     */
    private String nearbyLandmarks;

    /**
     * 地区 x坐标
     */
    private String mapX;

    /**
     * 地区 y坐标
     */
    private String mapY;

    /**
     * 月份
     */
    private Integer month;
    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;


}
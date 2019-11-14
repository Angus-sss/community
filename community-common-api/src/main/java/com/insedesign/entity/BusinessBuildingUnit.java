package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessBuildingUnit {
    /**
    * 单元ID
    */
    private String unitId;

    /**
    * 业务Id
    */
    private String bId;

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

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;
}
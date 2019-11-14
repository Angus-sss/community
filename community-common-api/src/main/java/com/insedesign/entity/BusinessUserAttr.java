package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessUserAttr {
    /**
    * 属性id
    */
    private Integer attrId;

    /**
    * 订单ID
    */
    private String bId;

    /**
    * 用户ID
    */
    private String userId;

    /**
    * 规格id
    */
    private String specCd;

    /**
    * 属性值
    */
    private String value;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;
}
package com.insedesign.communityuserapi.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author NALHOUG
 */
@Data
public class UserAttrVo {


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
}
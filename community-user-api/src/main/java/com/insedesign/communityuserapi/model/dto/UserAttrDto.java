package com.insedesign.communityuserapi.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class UserAttrDto {
    /**
     * 属性id
     */
    private String attrId;

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

}
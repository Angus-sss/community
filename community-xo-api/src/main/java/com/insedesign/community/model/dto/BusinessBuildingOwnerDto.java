package com.insedesign.community.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author NALHOUG
 */
@Data
public class BusinessBuildingOwnerDto implements Serializable {
    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 业主成员ID
     */
    private String memberId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 业主名称
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系人手机号
     */
    private String link;

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
     * 业主状态
     */
    private String operate;

    /**
     * 1001 业主本人 1002 家庭成员
     */
    private String ownerTypeCd;



}
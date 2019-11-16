package com.insedesign.community.model.vo;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author NALHOUG
 */
@Data
public class UserTagVo {


    /**
     * 业务Id
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 标签编码,参考tag表
     */
    private String tagCd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;


}
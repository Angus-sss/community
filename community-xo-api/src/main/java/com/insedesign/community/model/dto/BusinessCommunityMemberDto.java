package com.insedesign.community.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NALHOUG
 */
@Data
public class BusinessCommunityMemberDto implements Serializable {
    /**
     * ID
     */
    private String communityMemberId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 成员ID
     */
    private String memberId;

    /**
     * 成员类型
     */
    private String memberTypeCd;

    /**
     * 月份
     */
    private Integer month;



}
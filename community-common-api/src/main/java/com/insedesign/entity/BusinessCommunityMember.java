package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessCommunityMember {
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

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;

    /**
    * 审核状态
    */
    private String auditStatusCd;
}
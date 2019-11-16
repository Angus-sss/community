package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_community_member")
public class BusinessCommunityMember implements Serializable {
    /**
     * ID
     */
    @TableId(value = "community_member_id", type = IdType.INPUT)
    private String communityMemberId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 小区ID
     */
    @TableField(value = "community_id")
    private String communityId;

    /**
     * 成员ID
     */
    @TableField(value = "member_id")
    private String memberId;

    /**
     * 成员类型
     */
    @TableField(value = "member_type_cd")
    private String memberTypeCd;

    /**
     * 月份
     */
    @TableField(value = "month")
    private Integer month;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    @TableField(value = "operate")
    private String operate;

    /**
     * 审核状态 0000 为  未审核 1111为已审核
     */
    @TableField(value = "audit_status_cd")
    private String auditStatusCd;

    /**
     * 0为删除  1为存在
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_COMMUNITY_MEMBER_ID = "community_member_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_COMMUNITY_ID = "community_id";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_MEMBER_TYPE_CD = "member_type_cd";

    public static final String COL_MONTH = "month";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_AUDIT_STATUS_CD = "audit_status_cd";

    public static final String COL_STATE = "state";
}
package com.insedesign.communityadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user_tag")
public class BusinessUserTag {
    /**
     * 打标ID
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    /**
     * 业务Id
     */
    @TableField(value = "b_id")
    private String bId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 标签编码,参考tag表
     */
    @TableField(value = "tag_cd")
    private String tagCd;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

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

    public static final String COL_TAG_ID = "tag_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TAG_CD = "tag_cd";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";
}
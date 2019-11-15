package com.insedesign.communityuser.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user_attr")
public class BusinessUserAttr implements Serializable {
    /**
     * 属性id
     */
    @TableId(value = "attr_id", type = IdType.INPUT)
    private String attrId;

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
     * 身份id
     */
    @TableField(value = "spec_cd")
    private String specCd;

    /**
     * 属性值
     */
    @TableField(value = "value")
    private String value;

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
     * 0为删除 1为存在
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ATTR_ID = "attr_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_SPEC_CD = "spec_cd";

    public static final String COL_VALUE = "value";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
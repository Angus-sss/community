package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_user_admin")
public class BusinessUserAdmin implements Serializable {
    /**
     * 管理员id
     */
    @TableId(value = "admin_di", type = IdType.INPUT)
    private String adminDi;

    /**
     * 管理员真实姓名
     */
    @TableField(value = "admin_name")
    private String adminName;

    /**
     * 管理员级别
     */
    @TableField(value = "rank")
    private String rank;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 1为存在 0为删除
     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ADMIN_DI = "admin_di";

    public static final String COL_ADMIN_NAME = "admin_name";

    public static final String COL_RANK = "rank";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_STATE = "state";
}
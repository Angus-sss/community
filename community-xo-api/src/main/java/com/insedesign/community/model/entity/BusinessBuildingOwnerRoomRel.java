package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building_owner_room_rel")
public class BusinessBuildingOwnerRoomRel implements Serializable {
    /**
     * 关系ID
     */
    @TableId(value = "rel_id", type = IdType.INPUT)
    private String relId;

    /**
     * 业主ID
     */
    @TableField(value = "owner_id")
    private String ownerId;

    /**
     * 房间ID
     */
    @TableField(value = "room_id")
    private String roomId;

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
     * 业务状态  2001 业主未迁入 2002 业主迁入 2003 业主迁出
     */
    @TableField(value = "operate")
    private String operate;

    /**
     * 0为删除 1为存在

     */
    @TableField(value = "state")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_REL_ID = "rel_id";

    public static final String COL_OWNER_ID = "owner_id";

    public static final String COL_ROOM_ID = "room_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";

    public static final String COL_STATE = "state";
}
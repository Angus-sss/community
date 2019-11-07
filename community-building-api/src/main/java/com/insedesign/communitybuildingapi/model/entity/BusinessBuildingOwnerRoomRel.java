package com.insedesign.communitybuildingapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_building_owner_room_rel")
public class BusinessBuildingOwnerRoomRel {
    /**
     * 关系ID
     */
    @TableField(value = "rel_id")
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
     * 业务状态  2001 业主未迁入 2002 业主迁入 2003 业主迁出
     */
    @TableField(value = "state")
    private String state;

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
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    @TableField(value = "operate")
    private String operate;

    public static final String COL_REL_ID = "rel_id";

    public static final String COL_OWNER_ID = "owner_id";

    public static final String COL_ROOM_ID = "room_id";

    public static final String COL_B_ID = "b_id";

    public static final String COL_STATE = "state";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_OPERATE = "operate";
}
package com.insedesign.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author NALHOUG
 */
@Data
public class BuildingOwnerRoomRelDto {
    /**
     * 关系ID
     */
    private String relId;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 业务状态  2001 业主未迁入 2002 业主迁入 2003 业主迁出
     */
    private String state;

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
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;

  }
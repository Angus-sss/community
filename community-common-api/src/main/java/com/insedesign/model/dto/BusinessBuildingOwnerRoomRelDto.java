package com.insedesign.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NALHOUG
 */
@Data
public class BusinessBuildingOwnerRoomRelDto implements Serializable {
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
     * 备注
     */
    private String remark;

    /**
     * 业务状态  2001 业主未迁入 2002 业主迁入 2003 业主迁出
     */
    private String operate;

}
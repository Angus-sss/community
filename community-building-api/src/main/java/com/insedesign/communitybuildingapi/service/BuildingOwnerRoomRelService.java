package com.insedesign.communitybuildingapi.service;

import com.insedesign.entity.BusinessBuildingOwnerRoomRel;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 11:25
 * @Explain:
 */
public interface BuildingOwnerRoomRelService {
    /**
     * 增
     * @param entity
     * @return
     */
    BusinessBuildingOwnerRoomRel insert(BusinessBuildingOwnerRoomRel entity);

    /**
     * 改
     * @param entity
     * @return
     */
    BusinessBuildingOwnerRoomRel update(BusinessBuildingOwnerRoomRel entity);

    /**
     * 查
     * @param id
     * @return
     */
    BusinessBuildingOwnerRoomRel select(String id);

    /**
     * 删除
     * @param id
     * @return
     */
    int del(String id);
}

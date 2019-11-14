package com.insedesign.communitybuildingapi.service;

import com.insedesign.entity.BusinessBuildingOwner;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 11:25
 * @Explain:
 */

public interface BuildingOwnerService {
    /**
     * 增
     * @param entity
     * @return
     */
    BusinessBuildingOwner insert(BusinessBuildingOwner entity);

    /**
     * 改
     * @param entity
     * @return
     */
    BusinessBuildingOwner update(BusinessBuildingOwner entity);

    /**
     * 查
     * @param id
     * @return
     */
    BusinessBuildingOwner select(String id);

    /**
     * 删除
     * @param id
     * @return
     */
    int del(String id);
}

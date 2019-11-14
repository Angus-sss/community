package com.insedesign.communitybuildingapi.service;

import com.insedesign.entity.BusinessBuildingRoom;

import java.util.List;

public interface BuildingRoomService {
    /**
     * 增
     * @param entity
     * @return
     */
    BusinessBuildingRoom insert(BusinessBuildingRoom entity);

    /**
     * 改
     * @param entity
     * @return
     */
    BusinessBuildingRoom update(BusinessBuildingRoom entity);

    /**
     * 查
     * @param id
     * @return
     */
    BusinessBuildingRoom select(String id);

    /**
     * 删除
     * @param id
     * @return
     */
    int del(String id);

    /**
     * 查找所有
     * @return
     */
    List<BusinessBuildingRoom> selectAll();

    /**
     * 分页查询
     * @param a
     * @param b
     * @return
     */
    List<BusinessBuildingRoom> selectPage(int a,int b);

    /**
     * 根据单元分页查询
     * @param a
     * @param b
     * @return
     */
    List<BusinessBuildingRoom> selectPageByUnit(int a,int b);



    /**
     * 批量删除
     * @param roomIds
     * @return
     */
    int delList(List<String> roomIds);




}
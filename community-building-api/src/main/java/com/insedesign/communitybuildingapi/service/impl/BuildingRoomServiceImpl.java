package com.insedesign.communitybuildingapi.service.impl;

import com.insedesign.communitybuildingapi.mapper.BusinessBuildingRoomMapper;
import com.insedesign.communitybuildingapi.service.BuildingRoomService;
import com.insedesign.entity.BusinessBuildingRoom;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author NALHOUG
 */
@Service
public class BuildingRoomServiceImpl implements BuildingRoomService {
    @Resource
    private BusinessBuildingRoomMapper buildingRoomMapper;

    @Override
    public BusinessBuildingRoom insert(BusinessBuildingRoom entity) {
        entity.setRoomId(DateFormatUtils.format(Long.parseLong(entity.getApartment()+new Date()), "yyyyMMddHHmmssssss"));
        if (0<buildingRoomMapper.insert(entity)){
            return buildingRoomMapper.selectById(entity.getRoomId());
        }
        return null;
    }

    @Override
    public BusinessBuildingRoom update(BusinessBuildingRoom entity) {
        if (0<buildingRoomMapper.updateById(entity)){
            return buildingRoomMapper.selectById(entity.getRoomId());
        }
        return null;
    }

    @Override
    public BusinessBuildingRoom select(String id) {
        return buildingRoomMapper.selectById(id);
    }

    @Override
    public int del(String id) {
        return buildingRoomMapper.deleteById(id);
    }

    @Override
    public List<BusinessBuildingRoom> selectAll() {
        return buildingRoomMapper.selectList(null);
    }

    @Override
    public List<BusinessBuildingRoom> selectPage(int a, int b) {
        return null;
    }

    @Override
    public List<BusinessBuildingRoom> selectPageByUnit(int a, int b) {
        return null;
    }

    @Override
    public int delList(List<String> roomId) {
        return buildingRoomMapper.deleteBatchIds(roomId);
    }
}
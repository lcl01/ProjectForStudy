package com.coder520.POI.LabEquipmentList.dao;

import com.coder520.POI.LabEquipmentList.entity.LabEquipmentList;

public interface LabEquipmentListMapper {
    int deleteByPrimaryKey(Long no);

    int insert(LabEquipmentList record);

    int insertSelective(LabEquipmentList record);

    LabEquipmentList selectByPrimaryKey(Long no);

    int updateByPrimaryKeySelective(LabEquipmentList record);

    int updateByPrimaryKey(LabEquipmentList record);
}
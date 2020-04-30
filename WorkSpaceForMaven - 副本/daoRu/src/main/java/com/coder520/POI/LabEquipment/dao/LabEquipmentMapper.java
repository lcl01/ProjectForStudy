package com.coder520.POI.LabEquipment.dao;

import com.coder520.POI.LabEquipment.entity.LabEquipment;
import com.coder520.POI.LabEquipment.entity.LabEquipmentKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabEquipmentMapper {
    int deleteByPrimaryKey(LabEquipmentKey key);

    int insert(LabEquipment record);

    int insertAddKey(LabEquipment record);

    int insertSelective(LabEquipment record);

    LabEquipment selectByPrimaryKey(LabEquipmentKey key);

    List<LabEquipment> selectByName(@Param("chinesename") String chinesename, @Param("whichlab") String whichlab, @Param("rawvalue") Double rawvalue);

    int updateByPrimaryKeySelective(LabEquipment record);

    int updateByPrimaryKeyWithBLOBs(LabEquipment record);

    int updateByPrimaryKey(LabEquipment record);
}
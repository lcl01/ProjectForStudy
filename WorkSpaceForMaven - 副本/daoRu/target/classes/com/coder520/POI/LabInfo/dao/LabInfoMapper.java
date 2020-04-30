package com.coder520.POI.LabInfo.dao;

import com.coder520.POI.LabInfo.entity.LabInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabInfoMapper {
    int deleteByPrimaryKey(Long labseqno);

    int insert(LabInfo record);

    int insertAddKey(LabInfo record);

    int insertSelective(LabInfo record);

    int insertSelectiveAddKey(LabInfo record);

    LabInfo selectByPrimaryKey(Long labseqno);

    LabInfo selectByLabName(String labname);

    LabInfo selectNewByLabName(String labname);

    List<LabInfo>  selectByLabNameAndId(@Param("labname") String labname, @Param("departmentseqno") Long departmentseqno);

    int updateByPrimaryKeySelective(LabInfo record);

    int updateByPrimaryKeyWithBLOBs(LabInfo record);

    int updateByPrimaryKey(LabInfo record);

    List<LabInfo> findNewLabInfo();

    List<LabInfo> findLabByName(String whichlab);

    List<LabInfo> findLabByManagerName(String teachername);
}
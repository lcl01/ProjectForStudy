package com.coder520.POI.UuserRolesMap.dao;

import com.coder520.POI.UuserRolesMap.entity.UuserRolesMap;

public interface UuserRolesMapMapper {
    int deleteByPrimaryKey(Long mapseqno);

    int insert(UuserRolesMap record);

    int insertSelective(UuserRolesMap record);

    UuserRolesMap selectByPrimaryKey(Long mapseqno);

    int updateByPrimaryKeySelective(UuserRolesMap record);

    int updateByPrimaryKeyWithBLOBs(UuserRolesMap record);

    int updateByPrimaryKey(UuserRolesMap record);
}
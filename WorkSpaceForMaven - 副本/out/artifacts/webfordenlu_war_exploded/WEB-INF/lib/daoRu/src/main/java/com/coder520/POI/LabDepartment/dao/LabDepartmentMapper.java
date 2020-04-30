package com.coder520.POI.LabDepartment.dao;

import com.coder520.POI.LabDepartment.entity.LabDepartment;

import java.util.List;

public interface LabDepartmentMapper {
    int deleteByPrimaryKey(Long departmentseqno);

    int insert(LabDepartment record);
    int insertAddKey(LabDepartment record);

    int insertSelective(LabDepartment record);

    LabDepartment selectByPrimaryKey(Long departmentseqno);
    LabDepartment selectByDepartmentName(String departmentname);

    int updateByPrimaryKeySelective(LabDepartment record);

    int updateByPrimaryKey(LabDepartment record);

    List<LabDepartment> findNewByName(String departmentName);
}
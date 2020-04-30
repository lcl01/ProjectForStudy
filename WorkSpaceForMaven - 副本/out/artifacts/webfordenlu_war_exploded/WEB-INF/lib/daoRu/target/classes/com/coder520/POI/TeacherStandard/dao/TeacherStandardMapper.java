package com.coder520.POI.TeacherStandard.dao;

import com.coder520.POI.TeacherStandard.entity.TeacherStandard;
import com.coder520.POI.TeacherStandard.entity.TeacherStandardKey;

import java.util.List;

public interface TeacherStandardMapper {
    int deleteByPrimaryKey(TeacherStandardKey key);

    int insert(TeacherStandard record);

    int insertAddKey(TeacherStandard record);

    int insertSelective(TeacherStandard record);

    TeacherStandard selectByPrimaryKey(TeacherStandardKey key);

    int updateByPrimaryKeySelective(TeacherStandard record);

    int updateByPrimaryKey(TeacherStandard record);

    List<TeacherStandard> findByName(String standardname);
}
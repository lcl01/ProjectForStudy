package com.coder520.POI.TeacherConferences.dao;

import com.coder520.POI.TeacherConferences.entity.TeacherConferences;
import com.coder520.POI.TeacherConferences.entity.TeacherConferencesKey;

import java.util.List;

public interface TeacherConferencesMapper {
    int deleteByPrimaryKey(TeacherConferencesKey key);

    int insert(TeacherConferences record);

    int insertSelective(TeacherConferences record);

    TeacherConferences selectByPrimaryKey(TeacherConferencesKey key);

    int updateByPrimaryKeySelective(TeacherConferences record);

    int updateByPrimaryKey(TeacherConferences record);

    List<TeacherConferences> findByName(String conferencename);

    int insertAddKey(TeacherConferences conferences);
}
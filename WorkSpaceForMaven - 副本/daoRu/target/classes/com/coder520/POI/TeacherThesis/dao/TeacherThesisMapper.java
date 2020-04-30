package com.coder520.POI.TeacherThesis.dao;

import com.coder520.POI.TeacherThesis.entity.TeacherThesis;
import com.coder520.POI.TeacherThesis.entity.TeacherThesisKey;

import java.util.List;

public interface TeacherThesisMapper {
    int deleteByPrimaryKey(TeacherThesisKey key);

    int insert(TeacherThesis record);

    int insertSelective(TeacherThesis record);

    TeacherThesis selectByPrimaryKey(TeacherThesisKey key);

    int updateByPrimaryKeySelective(TeacherThesis record);

    int updateByPrimaryKey(TeacherThesis record);

    List<TeacherThesis> findByName(String thesstname);

    int insertAddKey(TeacherThesis thesis);
}
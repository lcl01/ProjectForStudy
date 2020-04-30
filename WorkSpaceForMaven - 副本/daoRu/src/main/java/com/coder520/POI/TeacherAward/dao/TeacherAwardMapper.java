package com.coder520.POI.TeacherAward.dao;

import com.coder520.POI.TeacherAward.entity.TeacherAward;
import com.coder520.POI.TeacherAward.entity.TeacherAwardKey;

import java.util.List;

public interface TeacherAwardMapper {
    int deleteByPrimaryKey(TeacherAwardKey key);

    int insert(TeacherAward record);

    int insertSelective(TeacherAward record);

    TeacherAward selectByPrimaryKey(TeacherAwardKey key);

    int updateByPrimaryKeySelective(TeacherAward record);

    int updateByPrimaryKey(TeacherAward record);

    List<TeacherAward> findByName(String awardname);

    int insertAddKey(TeacherAward teacherAward);
}
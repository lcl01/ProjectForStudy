package com.coder520.POI.TeacherPatentrelated.dao;

import com.coder520.POI.TeacherPatentrelated.entity.TeacherPatentrelated;
import com.coder520.POI.TeacherPatentrelated.entity.TeacherPatentrelatedKey;

public interface TeacherPatentrelatedMapper {
    int deleteByPrimaryKey(TeacherPatentrelatedKey key);

    int insert(TeacherPatentrelated record);

    int insertSelective(TeacherPatentrelated record);

    TeacherPatentrelated selectByPrimaryKey(TeacherPatentrelatedKey key);

    int updateByPrimaryKeySelective(TeacherPatentrelated record);

    int updateByPrimaryKey(TeacherPatentrelated record);
}
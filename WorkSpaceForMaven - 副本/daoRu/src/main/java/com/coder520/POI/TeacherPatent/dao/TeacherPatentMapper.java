package com.coder520.POI.TeacherPatent.dao;

import com.coder520.POI.TeacherPatent.entity.TeacherPatent;
import com.coder520.POI.TeacherPatent.entity.TeacherPatentKey;

import java.util.List;

public interface TeacherPatentMapper {
    int deleteByPrimaryKey(TeacherPatentKey key);

    int insert(TeacherPatent record);

    int insertSelective(TeacherPatent record);

    TeacherPatent selectByPrimaryKey(TeacherPatentKey key);

    int updateByPrimaryKeySelective(TeacherPatent record);

    int updateByPrimaryKey(TeacherPatent record);

    List<TeacherPatent> findByName(String patentname);

    int insertAddKey(TeacherPatent teacherPatent);
}
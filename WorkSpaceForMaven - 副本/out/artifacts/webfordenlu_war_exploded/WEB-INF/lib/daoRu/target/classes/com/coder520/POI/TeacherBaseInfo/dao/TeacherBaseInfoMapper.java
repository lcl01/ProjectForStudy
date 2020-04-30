package com.coder520.POI.TeacherBaseInfo.dao;

import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;

import java.util.List;

public interface TeacherBaseInfoMapper {
    int deleteByPrimaryKey(Long teacherseqno);

    int insert(TeacherBaseInfo record);

    int insertSelective(TeacherBaseInfo record);

    TeacherBaseInfo selectByPrimaryKey(Long teacherseqno);

    int updateByPrimaryKeySelective(TeacherBaseInfo record);

    int updateByPrimaryKey(TeacherBaseInfo record);

    List<TeacherBaseInfo> findTeacherByName(String teachername);

    List<TeacherBaseInfo> findNewTeacherByName(String teachername);

    int insertAddKey(TeacherBaseInfo teacherBaseInfo);

    List<TeacherBaseInfo> findNewTeacher();
}
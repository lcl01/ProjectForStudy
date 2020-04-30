package com.coder520.POI.TeacherProject.dao;

import com.coder520.POI.TeacherProject.entity.TeacherProject;
import com.coder520.POI.TeacherProject.entity.TeacherProjectKey;

import java.util.List;

public interface TeacherProjectMapper {
    int deleteByPrimaryKey(TeacherProjectKey key);

    int insert(TeacherProject record);

    int insertSelective(TeacherProject record);

    TeacherProject selectByPrimaryKey(TeacherProjectKey key);

    int updateByPrimaryKeySelective(TeacherProject record);

    int updateByPrimaryKey(TeacherProject record);

    List<TeacherProject> findByName(String projectname);

    int insertAddKey(TeacherProject teacherProject);
}
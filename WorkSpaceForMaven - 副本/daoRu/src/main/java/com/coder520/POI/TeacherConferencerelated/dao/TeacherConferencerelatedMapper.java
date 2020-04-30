package com.coder520.POI.TeacherConferencerelated.dao;

import com.coder520.POI.TeacherConferencerelated.entity.TeacherConferencerelated;
import com.coder520.POI.TeacherConferencerelated.entity.TeacherConferencerelatedKey;

public interface TeacherConferencerelatedMapper {
    int deleteByPrimaryKey(TeacherConferencerelatedKey key);

    int insert(TeacherConferencerelated record);

    int insertSelective(TeacherConferencerelated record);

    TeacherConferencerelated selectByPrimaryKey(TeacherConferencerelatedKey key);

    int updateByPrimaryKeySelective(TeacherConferencerelated record);

    int updateByPrimaryKey(TeacherConferencerelated record);
}
package com.coder520.POI.TeacherLiteraturerelated.dao;

import com.coder520.POI.TeacherLiteraturerelated.entity.TeacherLiteraturerelated;
import com.coder520.POI.TeacherLiteraturerelated.entity.TeacherLiteraturerelatedKey;

public interface TeacherLiteraturerelatedMapper {
    int deleteByPrimaryKey(TeacherLiteraturerelatedKey key);

    int insert(TeacherLiteraturerelated record);

    int insertSelective(TeacherLiteraturerelated record);

    TeacherLiteraturerelated selectByPrimaryKey(TeacherLiteraturerelatedKey key);

    int updateByPrimaryKeySelective(TeacherLiteraturerelated record);

    int updateByPrimaryKey(TeacherLiteraturerelated record);
}
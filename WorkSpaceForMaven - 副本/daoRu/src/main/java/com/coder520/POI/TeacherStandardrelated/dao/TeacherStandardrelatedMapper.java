package com.coder520.POI.TeacherStandardrelated.dao;

import com.coder520.POI.TeacherStandardrelated.entity.TeacherStandardrelated;
import com.coder520.POI.TeacherStandardrelated.entity.TeacherStandardrelatedKey;

public interface TeacherStandardrelatedMapper {
    int deleteByPrimaryKey(TeacherStandardrelatedKey key);

    int insert(TeacherStandardrelated record);

    int insertSelective(TeacherStandardrelated record);

    TeacherStandardrelated selectByPrimaryKey(TeacherStandardrelatedKey key);

    int updateByPrimaryKeySelective(TeacherStandardrelated record);

    int updateByPrimaryKey(TeacherStandardrelated record);
}
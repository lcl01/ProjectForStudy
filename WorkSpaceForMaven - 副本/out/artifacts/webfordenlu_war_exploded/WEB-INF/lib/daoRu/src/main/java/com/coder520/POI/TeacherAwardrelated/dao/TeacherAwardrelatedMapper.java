package com.coder520.POI.TeacherAwardrelated.dao;

import com.coder520.POI.TeacherAwardrelated.entity.TeacherAwardrelated;
import com.coder520.POI.TeacherAwardrelated.entity.TeacherAwardrelatedKey;

public interface TeacherAwardrelatedMapper {
    int deleteByPrimaryKey(TeacherAwardrelatedKey key);

    int insert(TeacherAwardrelated record);

    int insertSelective(TeacherAwardrelated record);

    TeacherAwardrelated selectByPrimaryKey(TeacherAwardrelatedKey key);

    int updateByPrimaryKeySelective(TeacherAwardrelated record);

    int updateByPrimaryKey(TeacherAwardrelated record);
}
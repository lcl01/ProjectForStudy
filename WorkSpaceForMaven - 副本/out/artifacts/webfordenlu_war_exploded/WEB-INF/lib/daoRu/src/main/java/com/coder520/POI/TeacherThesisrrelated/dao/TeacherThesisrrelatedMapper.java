package com.coder520.POI.TeacherThesisrrelated.dao;

import com.coder520.POI.TeacherThesisrrelated.entity.TeacherThesisrrelated;
import com.coder520.POI.TeacherThesisrrelated.entity.TeacherThesisrrelatedKey;

public interface TeacherThesisrrelatedMapper {
    int deleteByPrimaryKey(TeacherThesisrrelatedKey key);

    int insert(TeacherThesisrrelated record);

    int insertSelective(TeacherThesisrrelated record);

    TeacherThesisrrelated selectByPrimaryKey(TeacherThesisrrelatedKey key);

    int updateByPrimaryKeySelective(TeacherThesisrrelated record);

    int updateByPrimaryKey(TeacherThesisrrelated record);
}
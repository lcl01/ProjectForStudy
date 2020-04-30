package com.coder520.POI.TeacherProjectrelated.dao;

import com.coder520.POI.TeacherProjectrelated.entity.TeacherProjectrelated;
import com.coder520.POI.TeacherProjectrelated.entity.TeacherProjectrelatedKey;

public interface TeacherProjectrelatedMapper {
    int deleteByPrimaryKey(TeacherProjectrelatedKey key);

    int insert(TeacherProjectrelated record);

    int insertSelective(TeacherProjectrelated record);

    TeacherProjectrelated selectByPrimaryKey(TeacherProjectrelatedKey key);

    int updateByPrimaryKeySelective(TeacherProjectrelated record);

    int updateByPrimaryKey(TeacherProjectrelated record);
}
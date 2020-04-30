package com.coder520.POI.TeacherLiterature.dao;

import com.coder520.POI.TeacherLiterature.entity.TeacherLiterature;
import com.coder520.POI.TeacherLiterature.entity.TeacherLiteratureKey;

import java.util.List;

public interface TeacherLiteratureMapper {
    int deleteByPrimaryKey(TeacherLiteratureKey key);

    int insert(TeacherLiterature record);

    int insertAddKey(TeacherLiterature record);

    int insertSelective(TeacherLiterature record);

    TeacherLiterature selectByPrimaryKey(TeacherLiteratureKey key);

    int updateByPrimaryKeySelective(TeacherLiterature record);

    int updateByPrimaryKey(TeacherLiterature record);

    List<TeacherLiterature> findByName(String literaturename);
}
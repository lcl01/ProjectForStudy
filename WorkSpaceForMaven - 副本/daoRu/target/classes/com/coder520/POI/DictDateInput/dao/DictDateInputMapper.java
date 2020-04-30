package com.coder520.POI.DictDateInput.dao;

import com.coder520.POI.DictDateInput.entity.DictDateInput;

public interface DictDateInputMapper {
    int deleteByPrimaryKey(Long fieldseqno);

    int insert(DictDateInput record);

    int insertSelective(DictDateInput record);

    DictDateInput selectByPrimaryKey(Long fieldseqno);

    int updateByPrimaryKeySelective(DictDateInput record);

    int updateByPrimaryKey(DictDateInput record);
    DictDateInput findByName(String fieldvalue);
}
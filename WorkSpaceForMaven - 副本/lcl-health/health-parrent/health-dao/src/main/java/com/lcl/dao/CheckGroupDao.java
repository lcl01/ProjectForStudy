package com.lcl.dao;

import com.github.pagehelper.Page;
import com.lcl.pojo.CheckGroup;
import com.lcl.pojo.CheckItem;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map<String, Integer> map);

    Page<CheckGroup> selectByCondition(String queryString);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void deleteAssociation(Integer id);

    void edit(CheckGroup checkGroup);

    CheckGroup findById(Integer id);

    List<CheckGroup> findAll();

}

package com.health.service;

import com.health.pojo.CheckGroup;
import com.health.pojo.PageResult;

import java.util.List;

public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    List<CheckGroup> findAll();

}

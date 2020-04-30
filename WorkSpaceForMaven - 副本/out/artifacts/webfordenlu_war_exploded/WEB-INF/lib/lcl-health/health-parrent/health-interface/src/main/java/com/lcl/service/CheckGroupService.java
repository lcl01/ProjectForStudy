package com.lcl.service;

import com.lcl.entity.PageResult;
import com.lcl.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    void add(CheckGroup checkGroup,Integer[] checkitemIds);

   public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

   public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

   public void edit(CheckGroup checkGroup, Integer[] checkitemids);

   public CheckGroup findById(Integer id);

   public List<CheckGroup> findAll();
}

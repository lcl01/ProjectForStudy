package com.lcl.service;


import com.lcl.entity.PageResult;
import com.lcl.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);

   public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

   public void delete(Integer id);

   public void edit(CheckItem checkItem);

   public CheckItem findById(int id);

   public List<CheckItem> findAll();

}

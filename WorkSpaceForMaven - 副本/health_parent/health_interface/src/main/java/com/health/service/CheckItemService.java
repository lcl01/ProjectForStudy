package com.health.service;

import com.health.pojo.CheckItem;
import com.health.pojo.PageResult;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    public void delete(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);

    public List<CheckItem> findAll();
}

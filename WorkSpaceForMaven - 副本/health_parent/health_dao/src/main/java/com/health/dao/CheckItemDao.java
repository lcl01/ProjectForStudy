package com.health.dao;

import com.health.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectByCondition(String queryString);
    public long findCountByCheckItemId(Integer checkItemId);
    public void deleteById(Integer id);
    public CheckItem findById(Integer id);
   List<CheckItem> findCheckItemById(Integer id);
    public void edit(CheckItem checkItem);

    public List<CheckItem> findAll();
}

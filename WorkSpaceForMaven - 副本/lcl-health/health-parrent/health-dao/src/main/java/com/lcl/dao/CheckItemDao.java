package com.lcl.dao;

import com.github.pagehelper.Page;
import com.lcl.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    public Page<CheckItem> selectByCondition(String queryString);

    public long findCountByCheckItemId(Integer id);

   public void deleteById(Integer id);

    public void edit(CheckItem checkItem);

   public CheckItem findById(int id);

    public List<CheckItem> findAll();
}

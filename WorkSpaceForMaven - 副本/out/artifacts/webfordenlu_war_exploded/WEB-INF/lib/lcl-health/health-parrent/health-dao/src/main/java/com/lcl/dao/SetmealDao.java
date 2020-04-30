package com.lcl.dao;

import com.github.pagehelper.Page;
import com.lcl.pojo.CheckItem;
import com.lcl.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface  SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);

    public Page<CheckItem> selectByCondition(String queryString);

   public List<Setmeal> findAll();

   public Setmeal findById(int id);

   public List<Map<String,Object>> findSetmealCount();

}
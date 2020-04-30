package com.health.dao;

import com.github.pagehelper.Page;
import com.health.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(Map<String, Integer> map);

    Page<Setmeal> selectByCondition(String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);

    List<Map<String, Object>> findSetmealCount();
}

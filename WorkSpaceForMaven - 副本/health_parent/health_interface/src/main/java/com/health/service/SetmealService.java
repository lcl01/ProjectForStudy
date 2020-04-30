package com.health.service;

import com.health.pojo.PageResult;
import com.health.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealService {

    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);

    List<Map<String, Object>> findSetmealCount();

}

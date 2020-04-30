package com.itheima.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.Category;
import com.itheima.dao.CategoryDao;

import java.util.List;
public class CategoryService {
    private CategoryDao categoryDao= new CategoryDao();
    public String findAll() throws Exception {
        List<Category> list= categoryDao.finAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(list);
    }
}

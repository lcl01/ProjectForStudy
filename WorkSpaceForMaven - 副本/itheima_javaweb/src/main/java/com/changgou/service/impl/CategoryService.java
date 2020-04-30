package com.itheima.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.Category;
import com.itheima.constant.Constants;
import com.itheima.dao.CategoryDao;
import com.itheima.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    private ObjectMapper objectMapper = new ObjectMapper();
    public String findAll() throws Exception{
        Jedis jedis = null;
        String data  =null;
        try {
            jedis = JedisUtil.getJedis();
            data = getFromRedis(jedis);
            if(data == null){
                //3. 从Mysql获得, 再存到Redis里面
                System.out.println("Redis里面是没有数据的,从MySql获得,再存到Redis里面...");
                data = getFromMySql();
                saveToRedis(jedis,data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            data = getFromMySql();
        }finally {
            JedisUtil.close(jedis);
            return  data;
        }

//        return objectMapper.writeValueAsString(list);
    }

    private void saveToRedis(Jedis jedis, String data) {
        if (jedis!=null) {
            jedis.select(1);
            jedis.set(Constants.TRAVEL_CATEGORY_DATA,data);
        }
    }
    private String getFromMySql() throws Exception {
        List<Category> list=categoryDao.findAll();
        String categoryData  = objectMapper.writeValueAsString(list);
        return categoryData;
    }

    private String getFromRedis(Jedis jedis) {
        if(jedis != null){
            jedis.select(1);
            return jedis.get(Constants.TRAVEL_CATEGORY_DATA);
        }
        return null;
    }
}

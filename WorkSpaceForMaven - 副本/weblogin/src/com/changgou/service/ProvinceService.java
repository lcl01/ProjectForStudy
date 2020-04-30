package com.changgou.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.changgou.bean.Province;
import com.changgou.dao.ProvinceDao;
import com.changgou.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceService {

    public String findAll() throws Exception {
        String data = null;
        Jedis jedis = null;
        try {
            jedis = JedisUtils.getJedis();
            data=getFromRedis(jedis);
            if (data==null) {
                System.out.println("Redis里面没有数据, 从mysql获得,再存到redis里面");
                data=getFromMySql();
                saveToRedis(jedis,data);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Redis服务器有异常(没开),从mysql获得...");
            data = getFromMySql();
        }finally {
            jedis.close();
            return data;
        }
    }

    private void saveToRedis(Jedis jedis, String data) {
        if (jedis!=null) {
            jedis.set("province_value",data);
        }
    }

    private String getFromRedis(Jedis jedis) {
        if (jedis!=null) {
            return jedis.get("province_value");
        }
        return null;
    }

    private String getFromMySql() throws Exception {
        ProvinceDao provinceDao = new ProvinceDao();
        List<Province> list=provinceDao.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(list);
        return data;
    }

}

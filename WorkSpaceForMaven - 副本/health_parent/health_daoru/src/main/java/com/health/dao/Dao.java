package com.health.dao;

import com.health.pojo.ShengShiBiao;
import com.health.utils.C3P0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Dao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0Utils.getDataSource());
    public void daoru(ShengShiBiao shengShiBiao){
        String sql="insert into shengshibiao"+" values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params={shengShiBiao.getId()
        ,shengShiBiao.getProvince_id()
        ,shengShiBiao.getProvince_name()
        ,shengShiBiao.getCity_id()
        ,shengShiBiao.getRegion3_city_name()
        ,shengShiBiao.getRegion3_town_id()
        ,shengShiBiao.getRegion3_town_name()
        ,shengShiBiao.getRegion3_province_id()
        ,shengShiBiao.getRegion3_province_name()
        ,shengShiBiao.getRegion3_city_id()};
        jdbcTemplate.update(sql,params);
    }
}

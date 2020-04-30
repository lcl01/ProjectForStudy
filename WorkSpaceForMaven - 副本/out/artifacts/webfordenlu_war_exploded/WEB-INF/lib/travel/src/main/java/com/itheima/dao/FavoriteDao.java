package com.itheima.dao;

import com.itheima.bean.Favorite;
import com.itheima.bean.Route;
import com.itheima.utils.C3P0Util;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FavoriteDao {
   JdbcTemplate jdbcTemplate= new JdbcTemplate(C3P0Util.getDataSource());
    public Favorite isFavirite(int uid, String rid) {
        String sql="select * from tab_favorite where rid =? and uid=?";
        Favorite favorite = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper <>(Favorite.class), rid, uid);
        return favorite;
    }

    public void addFavorite(int uid, String rid) {
        String sql="insert into tab_favorite values(?,?,?)";
        jdbcTemplate.update(sql,rid,new Date(),uid);

    }

    public void updateCount(String rid) {
        String sql="update tab_route set count =count+1 where rid= ?";
        jdbcTemplate.update(sql,rid);
    }

    public int findCount(int uid) {
        String sql="select count(*) from tab_favorite where uid=?";
       Long n = jdbcTemplate.queryForObject(sql, Long.class, uid);
        int i = n.intValue();
        return i;
    }

    public List <Favorite> findPage(int uid, int a, int b) throws InvocationTargetException, IllegalAccessException {
        List <Favorite> list = new ArrayList <>();
        String sql="select * from tab_favorite f,tab_route r where f.rid=r.rid and f.uid=? limit ?,? ";
        List <Map <String, Object>> mapList = jdbcTemplate.queryForList(sql, uid, a, b);
        for (Map <String, Object> map : mapList) {
            Favorite favorite = new Favorite();
            BeanUtils.populate(favorite,map);
            Route route = new Route();
            BeanUtils.populate(route,map);
            favorite.setRoute(route);
            list.add(favorite);
        }
        return list;
    }
}

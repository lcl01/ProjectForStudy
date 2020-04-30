package com.itheima.dao;

import com.itheima.bean.Favorite;
import com.itheima.bean.Route;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FavoriteDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
    public Favorite isFavorite(int uid, String rid) {
        String sql="SELECT * FROM tab_favorite WHERE rid=? and uid = ?";
        try {
            Favorite favorite = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), rid, uid);
            return favorite;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addFavorite(int uid, String rid) {
        String sql = "INSERT INTO tab_favorite VALUES(?,?,?)";
        jdbcTemplate.update(sql, rid, new Date(),uid);
    }

    public void updateFavoriteCount(String rid) {
        String sql="UPDATE tab_route SET COUNT=COUNT+1 WHERE rid=?";
        jdbcTemplate.update(sql,rid);
    }

    public int findCount(int uid) {
        String sql="SELECT COUNT(*) FROM tab_favorite WHERE uid=?";
        return jdbcTemplate.queryForObject(sql,Long.class,uid).intValue();
    }

    public List<Favorite> findPage(int uid, int a, int b) throws InvocationTargetException, IllegalAccessException {
        List<Favorite> list = new ArrayList<Favorite>();
        String sql="SELECT * FROM tab_favorite f,tab_route r WHERE f.rid=r.rid AND  f.uid=? LIMIT ?,?";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, uid, a, b);
        for (Map<String, Object> map : mapList) {
            Favorite favorite = new Favorite();
            BeanUtils.populate(favorite,map);
            Route route = new Route();
            BeanUtils.populate(route,map);
            favorite.setRoute(route);
            list.add(favorite);
        }
        return list;
    }

    public int findFavoriteCount(String rname, String startPrice, String endPrice) {
        String sql = "SELECT COUNT(*) FROM tab_route WHERE rflag='1'";
        List<Object> params = new ArrayList<Object>();
        if(rname != null && rname.trim().length() > 0){
            sql +=" AND rname LIKE ?";
            System.out.println("rname="+rname);
            params.add("%"+rname+"%");
        }
        if(startPrice != null && startPrice.trim().length() > 0){
            sql+=" AND price >= ?";
            params.add(startPrice);
        }

        if(endPrice != null && endPrice.trim().length() > 0){
            sql+=" AND price <= ?";
            params.add(endPrice);
        }
        return jdbcTemplate.queryForObject(sql,Long.class,params.toArray()).intValue();
    }

    public List<Route> findFavoriteRank(int a, int b, String rname, String startPrice, String endPrice) {
        String sql = "SELECT * FROM tab_route WHERE rflag='1'";
        List<Object> params = new ArrayList<Object>();
        if(rname != null && rname.trim().length() > 0){
            sql +=" AND rname LIKE ?";
            params.add("%"+rname+"%");
        }

        if(startPrice != null && startPrice.trim().length() > 0){
            sql+=" AND price >= ?";
            params.add(startPrice);
        }

        if(endPrice != null && endPrice.trim().length() > 0){
            sql+=" AND price <= ?";
            params.add(endPrice);
        }

        sql+=" ORDER BY COUNT DESC LIMIT ?,?";
        params.add(a);
        params.add(b);
        List<Route> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), params.toArray());
        return list;
    }
}

package com.itheima.dao;

import com.itheima.bean.Route;
import com.itheima.bean.RouteImg;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class RouteDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0Utils.getDataSource());
    public List<Route> findPopularList() {
        String sql="select * from tab_route where rflag = '1' order by count desc limit 0,4";

        List<Route> routes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routes;
    }


    public List<Route> findNewList() {
        String sql="select * from tab_route where rflag = '1' order by rdate desc limit 0,4";

        List<Route> routes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routes;

    }

    public List<Route> findThemeList() {
        String sql="select * from tab_route where rflag = '1' and isThemeTour = '1'  order by rdate desc limit 0,4";

        List<Route> routes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routes;
    }

    public int findCount(int cid) {
        String sql="SELECT count(*) FROM tab_route WHERE cid = ? AND rflag='1'";
        Long l=jdbcTemplate.queryForObject(sql, Long.class, cid);
        return l.intValue();
    }

    public List<Route> findPage(int cid, int a, int b) {
        String sql="SELECT * FROM tab_route WHERE cid = ? AND rflag='1' limit ?,?";
        List<Route> routes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), cid, a, b);
        return routes;
    }

    public Map<String, Object> findRouteByRid(String rid) throws Exception{
        String sql = "SELECT * FROM tab_route r, tab_category c, tab_seller s WHERE r.cid = c.cid AND r.sid = s.sid AND r.rflag = '1' AND r.rid = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, rid);
//        System.out.println("map=" + map);
        return map;
    }

    public List<RouteImg> findRouteImgsByRid(String rid) {
        String sql="SELECT * FROM tab_route_img WHERE rid=?";
        List<RouteImg> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RouteImg.class),rid);
        return list;
    }

    public int findFavoriteCount() {
        String sql = "SELECT COUNT(*) FROM tab_route WHERE rflag='1'";
        //执行sql返回一个int整型数据
        return jdbcTemplate.queryForObject(sql,Long.class).intValue();
    }

    public List<Route> findFavoriteRank(int a, int b) {
        String sql = "SELECT * FROM tab_route WHERE rflag='1' ORDER BY COUNT DESC LIMIT ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class),a,b);
    }
}

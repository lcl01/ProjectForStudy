package com.changgou.dao;

import com.changgou.bean.Route01;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class RouteDao01 {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
    public void addRoute(Route01 route) throws SQLException {
        String sql = " insert into tab_route01(rname,price,routeIntroduce,rflag,rdate,isThemeTour,count,cid,rimage,sid,sourceId)" +
                " values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                route.getRname(),
                route.getPrice(),
                route.getRouteIntroduce(),
                route.getRflag(),
                route.getRdate(),
                route.getIsThemeTour(),
                route.getCount(),
                route.getCid(),
                route.getRimage(),
                route.getSid(),
                route.getSourceId(),
        };
        jdbcTemplate.update(sql,params);
    }
}

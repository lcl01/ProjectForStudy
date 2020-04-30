package com.lcl.dao;

import com.lcl.bean.Route;
import com.lcl.utils.C3P0Util;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());

    public void addRoute(Route route) throws SQLException {
        String sql = " insert into crawler(rname,price,routeIntroduce,rflag,rdate,isThemeTour,count,cid,rimage,sid,sourceId)" +
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

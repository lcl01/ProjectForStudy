package com.itheima.dao;

import com.itheima.bean.Route;
import com.itheima.bean.RouteImg;
import com.itheima.utils.C3P0Util;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());

    public List<Route> findPopularList() {
        String sql = "select * from tab_route where rflag = '1' order by count desc limit 0,4";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Route.class));
    }

    public List <Route> findNewList() {
        String sql = "select * from tab_route where rflag = '1' order by rdate desc limit 0,4";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Route.class));
    }

    public List <Route> findThemeList() {
        String sql = "select * from tab_route where rflag = '1' and isThemeTour = '1'  order by rdate desc limit 0,4";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Route.class));
    }

    public int findCount(int cid,String rname) {

        String sql="select count(*) from tab_route where rflag='1'";
        List <Object> params = new ArrayList <Object>();
        if (cid!=0){
            sql+="and cid = ? ";
            params.add(cid);
        }
        if(rname!=null && !"".equals(rname)){
            sql+="and rname like ?";
            params.add("%"+rname+"%");
        }
        Long n=jdbcTemplate.queryForObject(sql,Long.class,params.toArray());
        return n.intValue();
    }

    public List <Route> findPage(int cid, int a, int b,String rname) {
        String sql="select * from tab_route where rflag='1'";
        List <Object> params = new ArrayList <>();
        if(cid !=0){
            sql+="AND cid= ? ";
            params.add(cid);
        }
        if(rname !=null && !"".equals(rname)){
            sql+="AND rname LIKE ?";
            params.add("%"+rname+"%");
        }
        sql+="limit ?,?";
        params.add(a);
        params.add(b);

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Route.class),params.toArray());
    }

    public Map <String, Object> findRouteByRid(String rid) {
        String sql="select * from tab_route r,tab_category c,tab_seller s where r.cid=c.cid and r.sid=s.sid and r.rflag='1' and r.rid= ?  ";
        Map <String, Object> map = jdbcTemplate.queryForMap(sql, rid);
        return map;
    }

    public List <RouteImg> findRouteImgsByRid(String rid) {
       String sql="select * from tab_route_img where rid= ? ";
        List <RouteImg> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper <RouteImg>(RouteImg.class), rid);
        return list;
    }

    public int findFavoriteCounte(String rname, String startPrice, String endPrice) {
        String sql="select count(*) from tab_route where rflag='1' ";
        List <Object> params = new ArrayList <Object>();
        if(rname !=null && rname.trim().length()>0){
            sql+="and rname like ? ";
            System.out.println("rname=" + rname);
            params.add("%"+rname+"%");
        }
        if(startPrice !=null && startPrice.trim().length()>0){
            sql+="AND  Price >= ? ";

            params.add(startPrice);

        }if(endPrice !=null && endPrice.trim().length()>0){
            sql+=" AND price <= ? ";
            params.add(endPrice);
        }
        Long n = jdbcTemplate.queryForObject(sql, Long.class,params.toArray());
        int i = n.intValue();
        return i;
    }

    public List <Route> findFavoriteRank(int a, int b, String rname, String startPrice, String endPrice) {
        String  sql="select * from tab_route where rflag='1' ";
        List <Object> params = new ArrayList <Object>();
        if(rname !=null && rname.trim().length()>0){
            sql+=" and rname like ? ";
            System.out.println("rname=" + rname);
            params.add("%"+rname+"%");
        }if(startPrice !=null && startPrice.trim().length()>0){
            sql+=" AND  price >= ? ";

            params.add(startPrice);

        }if(endPrice !=null && endPrice.trim().length()>0){
            sql+=" AND price <= ? ";
            params.add(endPrice);
        }
        sql+=" ORDER by count desc limit ?,? ";
        params.add(a);
        params.add(b);
        List <Route> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper <>(Route.class), params.toArray());
        return list;

    }
}

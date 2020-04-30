package com.itheima.service;

import com.itheima.bean.*;
import com.itheima.constants.Constants;
import com.itheima.dao.RouteDao;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutService {
    private  RouteDao routeDao = new RouteDao();

    public Map <String, List <Route>> findSelect() {
       List<Route> popularList= routeDao.findPopularList();
       List<Route> newList= routeDao.findNewList();
       List<Route> themeList= routeDao.findThemeList();
        Map<String, List <Route>> map = new HashMap <String, List <Route>>();
        map.put("popularList",popularList);
        map.put("newList",newList);
        map.put("themeList",themeList);

        return map;
    }

    public PageBean <Route> findByPage(int cid, int curPage, String rname) {
        int curSize= Constants.ROUTE_CUR_SIZE;
        int count=routeDao.findCount(cid,rname);
        int sumPage=0;
        if(count % curSize==0){
            sumPage=count / curSize;
        }else {
            sumPage=count /curSize+1;
        }
        int b=Constants.ROUTE_CUR_SIZE;
        int a=(curPage-1)*b;
       List<Route> list= routeDao.findPage(cid,a,b,rname);
        PageBean <Route> pageBean = new PageBean <>();
        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);

        return  pageBean;
    }

    public Route findByRid(String rid) throws InvocationTargetException, IllegalAccessException {
       Map<String,Object> map=routeDao.findRouteByRid(rid);
        Route route = new Route();
        BeanUtils.populate(route,map);
        Category category = new Category();
        BeanUtils.populate(category,map);
        Seller seller = new Seller();
        BeanUtils.populate(seller,map);
        route.setSeller(seller);
        route.setCategory(category);
        List<RouteImg> routeImgList=routeDao.findRouteImgsByRid(rid);
        route.setRouteImgList(routeImgList);
        return route;
    }

    public PageBean <Route> findFavoriteRank(int curPage, String rname, String startPrice, String endPrice) {
        int curSize=Constants.ROUTE_CUR_SIZE;
        int count=routeDao.findFavoriteCounte(rname,startPrice,endPrice);
        int sumPage=0;
        if (count%curSize==0) {
            sumPage=count/curSize;
        }else {
            sumPage=count/curSize+1;
        }
        int a=(curPage-1)*curSize;
        int b=Constants.ROUTE_CUR_SIZE;
        List<Route> list=routeDao.findFavoriteRank(a,b,rname,startPrice,endPrice);
        PageBean <Route> pageBean = new PageBean <>();
        pageBean.setList(list);
        pageBean.setSumPage(sumPage);
        pageBean.setCount(count);
        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        return pageBean;
    }
}

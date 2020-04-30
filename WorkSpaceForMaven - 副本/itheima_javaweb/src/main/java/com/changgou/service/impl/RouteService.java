package com.itheima.service.impl;

import com.itheima.bean.*;
import com.itheima.constant.Constants;
import com.itheima.dao.RouteDao;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteService {
    private RouteDao routeDao=new RouteDao();
    public Map<String, List<Route>> findSelected(){
        List<Route> popularList=routeDao.findPopularList();
        List<Route> newList=routeDao.findNewList();
        List<Route> themeList=routeDao.findThemeList();
        Map<String,List<Route>> map = new HashMap<String,List<Route>>();
        map.put("popularList",popularList);
        map.put("newList",newList);
        map.put("themeList",themeList);
        return map;
    }

    public PageBean<Route> findByPage(int cid, int curPage) {
        int curSize = Constants.ROUTE_CUR_SIZE;
        int count = routeDao.findCount(cid);
        int sumPage = 0;
        if (count % curSize == 0) {
            sumPage=count/curSize;
        }else {
            sumPage=count/curSize+1;
        }
        int b=curSize;
        int a=(curPage-1)*b;
        List<Route> list = routeDao.findPage(cid,a,b);
        PageBean<Route> pageBean = new PageBean<Route>();
        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);
        return pageBean;
    }

    public Route findByRid(String rid) throws Exception{
        Map <String,Object> map = routeDao.findRouteByRid(rid);
        Route route = new Route();
        BeanUtils.populate(route,map);
        Category category = new Category();
        BeanUtils.populate(category,map);
        Seller seller = new Seller();
        BeanUtils.populate(seller,map);
        route.setSeller(seller);
        route.setCategory(category);
        List<RouteImg> routeImgList =  routeDao.findRouteImgsByRid(rid);
        route.setRouteImgList(routeImgList);
        return route;
    }

    public PageBean<Route> findFavoriteRank(int curPage) {
        int curSize = Constants.FAVORITE_RANK_CUR_SIZE;
        int count = routeDao.findFavoriteCount();
        int sumPage = 0;
        if(count % curSize == 0){
            sumPage = count / curSize;
        }else{
            sumPage = count / curSize + 1;
        }
        int b =curSize;
        int a = (curPage -1)*b;
        List<Route> list = routeDao.findFavoriteRank(a,b);
        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);
        return pageBean;
    }
}

package com.itheima.service;

import com.itheima.bean.Favorite;
import com.itheima.bean.PageBean;
import com.itheima.bean.Route;
import com.itheima.constants.Constants;
import com.itheima.dao.FavoriteDao;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public class FavoriteService {
    private FavoriteDao favoriteDao= new FavoriteDao();
    public boolean isFavorite(int uid, String rid) {
        try {
            Favorite favorite= favoriteDao.isFavirite(uid,rid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addFavorite(int uid, String rid) throws SQLException {
        Connection connection=null;
        try {
            DataSource dataSource = C3P0Util.getDataSource();
            TransactionSynchronizationManager.initSynchronization();
            connection = DataSourceUtils.getConnection(dataSource);
            connection.setAutoCommit(false);
            favoriteDao.addFavorite(uid,rid);
            favoriteDao.updateCount(rid);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }finally {
            try {
                TransactionSynchronizationManager.clearSynchronization();
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

    public PageBean <Favorite> findByPage(int uid, int curPage) throws InvocationTargetException, IllegalAccessException {
        int curSize= Constants.ROUTE_CUR_SIZE;
        int count=favoriteDao.findCount(uid);
        int sumPage=0;
        if(count%curPage==0){
            sumPage=count/curSize;
        }else {
            sumPage=count/curSize+1;
        }
        int b=Constants.ROUTE_CUR_SIZE;
        int a=(curPage-1)*b;
        List<Favorite> list=favoriteDao.findPage(uid,a,b);
        PageBean <Favorite> pageBean = new PageBean <>();
        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);
        return pageBean;
    }


}

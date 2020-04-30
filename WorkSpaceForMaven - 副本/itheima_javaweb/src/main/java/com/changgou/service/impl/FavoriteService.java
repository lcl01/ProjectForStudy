package com.itheima.service.impl;

import com.itheima.bean.Favorite;
import com.itheima.bean.PageBean;
import com.itheima.bean.Route;
import com.itheima.constant.Constants;
import com.itheima.dao.FavoriteDao;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDao();
    public boolean isFavorite(int uid, String rid) {
        Favorite favorite =  favoriteDao.isFavorite(uid,rid);
        if (favorite != null){
            return  false;
        }else{
            return  true;
        }
    }

    public void addFavorite(int uid, String rid) throws Exception {
        Connection connection = null;
        try {
            //**************1,开启事务
            //获得数据源
            DataSource dataSource = C3P0Utils.getDataSource();
            //启动事务管理器（获取datasource操作数据库连接对象并绑定到当前线程中）
            TransactionSynchronizationManager.initSynchronization();
            //从数据源中获取jdbcTemplate操作的当前连接对象
            connection =DataSourceUtils.getConnection(dataSource);
            //设置连接不自动提交事务
            connection.setAutoCommit(false);

            //**************2,调用Dao
            //添加收藏
            favoriteDao.addFavorite(uid, rid);
            //收藏数量+1
            favoriteDao.updateFavoriteCount(rid);

            //**************3,提交事务
            connection.commit();
        } catch (Exception e) {
            //**************4,提交事务
            connection.rollback();
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                //**************5,还原成自动事务
                //释放当前线程与连接对象的绑定
                TransactionSynchronizationManager.clearSynchronization();
                //重置当前连接为自动提交事务
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public PageBean<Favorite> findByPage(int uid, int curPage) throws InvocationTargetException, IllegalAccessException {
        int curSize = Constants.FAVORITE_CUR_SIZE;
        int count = favoriteDao.findCount(uid);
        int sumPage = 0;
        if(count % curSize == 0){
            sumPage = count / curSize;
        }else{
            sumPage = count / curSize + 1;
        }
        int b = Constants.FAVORITE_CUR_SIZE;
        int a = (curPage -1)*b;
        List<Favorite> list = favoriteDao.findPage(uid,a,b);
        PageBean<Favorite> pageBean = new PageBean<>();

        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);
        return pageBean;
    }

    public PageBean<Route> findFavoriteRank(int curPage, String rname, String startPrice, String endPrice) {
        int curSize = Constants.FAVORITE_RANK_CUR_SIZE;
        int count = favoriteDao.findFavoriteCount(rname,startPrice,endPrice);
        int sumPage = 0;
        if(count % curSize == 0){
            sumPage = count / curSize;
        }else{
            sumPage = count / curSize + 1;
        }

        int b = Constants.FAVORITE_RANK_CUR_SIZE;
        int a = (curPage -1)*b;
        List<Route> list = favoriteDao.findFavoriteRank(a,b,rname,startPrice,endPrice);

        PageBean<Route> pageBean = new PageBean<>();

        pageBean.setCurPage(curPage);
        pageBean.setCurSize(curSize);
        pageBean.setCount(count);
        pageBean.setSumPage(sumPage);
        pageBean.setList(list);
        return  pageBean;
    }
}

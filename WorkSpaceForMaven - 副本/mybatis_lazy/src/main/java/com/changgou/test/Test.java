package com.itheima.test;

import com.changgou.beans.Account;
import com.changgou.beans.User;
import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class Test {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    private UserDao userDao;


    @Before
    public void init() throws IOException {
        in = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
        userDao = sqlSession.getMapper(UserDao.class);

    }

    @After
    public void destory() throws IOException {
        in.close();
    }

    @org.junit.Test
    public void fun02() {
        User byId = userDao.findById(41);
        System.out.println(byId);
    }

    @org.junit.Test
    public void fun01() {
//        userDao.findById(1);
        List<Account> ac = accountDao.findByAccountUser();
        for (Account account : ac) {
            System.out.println(account);
        }
    }

    @org.junit.Test
    public void fun03() {
        List<User> byUserAccount = userDao.findByUserAccount();
        for (User user : byUserAccount) {
            System.out.println(user);
            System.out.println(user.getAccounts().size());
        }
    }

    @org.junit.Test
    public void fun04() {
        User byId = userDao.findById(55);
        System.out.println(byId);
//        sqlSession.close();
////                sqlSession.clearCache();// 清理缓存
//        sqlSession=sqlSessionFactory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User byId1 = mapper.findById(55);
        User byId1 = userDao.findById(55);
        System.out.println(byId1);
        System.out.println(byId == byId1);
    }

    @org.junit.Test
    public void fun05() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user1 = mapper.findById(55);
        System.out.println(user1);
        sqlSession.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = userDao2.findById(55);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println(user1 == user2);
    }

}

package com.lcl.test;

import com.lcl.ssm.dao.AccountDao;
import com.lcl.ssm.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testFindAll() throws Exception{
//        InputStream in = org.apache.ibatis.io.Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
//        SqlSession sqlSession = sessionFactory.openSession();
//        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = ac.getBean(AccountDao.class);
        List <Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
//        sqlSession.close();
//        in.close();
    }
    @Test
    public void testSave() throws Exception {
        Account account = new Account();
        account.setName("小菲");
        account.setMoney(400d);

        // 加载配置文件
        InputStream in = org.apache.ibatis.io.Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        accountDao.saveAccount(account);

        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        in.close();
    }
}

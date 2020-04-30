package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.Oneway;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestMybatis
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2019/5/23 9:19
 * @Version V1.0
 */
public class TestMybatis {

    InputStream in;
    SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private AccountDao accountDao;
    private RoleDao roleDao;
    private UserDao userDao;
    @Before // 在执行@Test之前执行的方法
    public void init() throws Exception {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        accountDao = sqlSession.getMapper(AccountDao.class);
        roleDao=sqlSession.getMapper(RoleDao.class);
    }

    @After // 在执行@Test之后执行的方法
    public void destroy() throws Exception {
        sqlSession.commit(); // mybatis底层默认事务采用的手动提交的方式，需要手动提交事务，增删改才能有效
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindRoleUserList3(){
        //5.执行查询所有方法
        List<Account> roles = accountDao.findByAccountUser();


    }
    @Test
    public void testfindUserAccountList(){
        List <User> userAccountList = userDao.findUserAccountList();
        for (User user : userAccountList) {
            System.out.println(user);
            System.out.println(user.getAccounts().size());
        }
    }
    @Test
    public void testFirstLeverCache(){
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        UserDao userDao = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao.findById(42);
        System.out.println(user1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession2.getMapper(UserDao.class);
        User user2=mapper.findById(42);
        System.out.println(user2);
        sqlSession2.close();


    }
    @Test
    public void testFindAll(){
        List <User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市昌平区");

        userDao.saveUser(user);
    }
    @Test
    public void testDelete(){

        userDao.deleteUser(50);
    }
    @Test
    public  void testFindByName() {
        List <User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindAllAccount(){
        List<Account> list = accountDao.findAll();
        for(Account account:list){
            System.out.println(account);
        }
    }
    @Test
    public void testFindAccountUser2() throws Exception {
        List<Account> list = accountDao.findAllAccountUser2();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
//    @Test
//    public void testFindById(){
//        User user = userDao.findById(42);
//        System.out.println(user);
//    }


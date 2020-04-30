package com.health.test;



import com.health.beans.*;
import com.health.dao.Accountdao;
import com.health.dao.RoleDao;
import com.health.dao.UserDao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

public class Test {
    @org.junit.Test
    public void fun01() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        二级缓存 SqlSessionFactory
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
//        一级缓存 SqlSession
        SqlSession sqlSession = build.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User02> all = userDao.findAll();
        for (User02 user02 : all) {
            System.out.println(user02);
        }
        sqlSession.close();
        resourceAsStream.close();
    }
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private Accountdao accountdao;
    private RoleDao roleDao;
    @Before
    public void init() throws IOException {
        in=getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(in);
//        userDao = new UserDaoImpl(build);
        sqlSession = build.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        accountdao = sqlSession.getMapper(Accountdao.class);
        roleDao=sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void destroy()throws Exception{
//        sqlSession.commit();
        //6.释放资源
        in.close();
    }
    @org.junit.Test
    public void fun02(){
        List<User02> all = userDao.findAll();
        for (User02 user02 : all) {
            System.out.println(user02);
        }
    }
    @org.junit.Test
    public void save(){
        User02 user = new User02();
        user.setUsername("如花1");
        user.setAddress("中粮商务公园");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser02(user);
        System.out.println("保存操作之后："+user);
    }
    @org.junit.Test
    public void testSave(){
        User02 user = new User02();
        user.setUsername("如花2");
        user.setAddress("中粮商务公园");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser02(user);
        System.out.println("保存操作之后："+user);
    }
@org.junit.Test
    public void fun04(){
    User02 user = new User02();
    user.setId(52);
    user.setUsername("如花2");
    user.setAddress("中粮商务公园");
    user.setSex("男");
    user.setBirthday(new Date());
    userDao.updateUser(user);
}
    @org.junit.Test
    public void fun05(){
        userDao.delete(56);
    }
    @org.junit.Test
    public void fun06(){
       User02 user02=userDao.findById(55);
        System.out.println(user02);

    }
    @org.junit.Test
    public void fun07(){
        List<User02> name = userDao.findByName("小");
        for (User02 user02 : name) {
            System.out.println(user02);
        }
    }
    @org.junit.Test
    public void fun08(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
    @org.junit.Test
    public void fun09(){
        QueryVo vo = new QueryVo();
        User02 user02 = new User02();
        user02.setUsername("%王%");
        vo.setUser02(user02);
        List<User02> userByVo = userDao.findUserByVo(vo);
        for (User02 user021 : userByVo) {
            System.out.println(user021);
        }
    }
    @org.junit.Test
    public void fun10(){
        List<User03> all01 = userDao.findAll01();
        for (User03 user03 : all01) {
            System.out.println(user03);
        }
    }
     @org.junit.Test
    public void fun11(){
        List<User03> all01 = userDao.findAll01();
        for (User03 user03 : all01) {
            System.out.println(user03);
        }
    }
    @org.junit.Test
    public void fun12(){
        List<User02> all = userDao.findAll();
        for (User02 user02 : all) {
            System.out.println(user02);
        }
    }
    @org.junit.Test
    public void fun13(){
        User02 user02 = new User02();
        user02.setUsername("如花1");
        user02.setAddress("中粮商务公园");
        user02.setSex("男");
        user02.setBirthday(new Date());
        System.out.println("保存操作之前："+user02);
        //5.执行保存方法
        userDao.saveUser02(user02);
        System.out.println("保存操作之后："+user02);
    }
    @org.junit.Test
    public void testUpdate(){
        User02 user = new User02();
        user.setId(56);
        user.setUsername("石榴姐");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行更新方法
        userDao.updateUser(user);
    }
    @org.junit.Test
    public void fun14(){
        User02 byId = userDao.findById(55);
        System.out.println(byId);

    }
    @org.junit.Test
    public void fun15(){
        User02 user02 = new User02();
        user02.setSex("男");
        List<User02> user = userDao.findCondition(user02);
        for (User02 user021 : user) {
            System.out.println(user021);
        }
    }
    @org.junit.Test
    public void fun16(){
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(44);
        queryVo.setIds(ids);
        List<User02> user02s = userDao.findInIds(queryVo);
        for (User02 user02 : user02s) {
            System.out.println(user02);
        }

    }
    @org.junit.Test
    public void testFindAllAccount(){
        List<Account> all = accountdao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
    @org.junit.Test
    public void Account(){

        Account all = accountdao.findById(2);
            System.out.println(all);

    }
    @org.junit.Test
    public void fun19(){
        List<AccountUser> byAccountUser = accountdao.findByAccountUser();
        for (AccountUser accountUser : byAccountUser) {
            System.out.println(accountUser);
        }
    }
    @org.junit.Test
    public void fun20(){
        List<Account> all01 = accountdao.findAll01();
        for (Account user03 : all01) {
            System.out.println(user03);
        }
    }
    @org.junit.Test
    public void fun21(){
        List<User02> user02s = accountdao.findAll02();
        for (User02 user02 : user02s) {
            System.out.println(user02);
        }
    }
    @org.junit.Test
    public void fun22(){
        List<Role> all03 = roleDao.findAll03();
        for (Role role : all03) {
            System.out.println(role);
        }

    }
    @org.junit.Test
    public void fun23(){
        Role byId = roleDao.findById(2);
        System.out.println(byId);
    }
    @org.junit.Test
    public void fun24(){
        List<Role> byRoleUserList = roleDao.findByRoleUserList();
        for (Role role : byRoleUserList) {
            System.out.println(role);
        }
    }
    @org.junit.Test
    public void fun25(){
        List<User02> user02s = userDao.UserRoleList();
        for (User02 user02 : user02s) {
            System.out.println(user02);
        }
    }
}

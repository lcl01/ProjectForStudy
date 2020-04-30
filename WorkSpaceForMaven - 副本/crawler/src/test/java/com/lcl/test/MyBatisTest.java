package com.lcl.test;

import com.lcl.domain.QueryVo;
import com.lcl.domain.User;
import com.lcl.dao1.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private InputStream in;
    private static SqlSession sqlSession;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        in =Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }
    @After
    public  void destroy() throws IOException {
        sqlSession.commit();
        in.close();
    }
    @Test
    public void testfindAll() {

        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();

    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("如花2");
        user.setAddress("中粮商务公园");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(50);
        user.setUsername("如花2");
        user.setAddress("中粮商务公园");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        //5.执行删除方法
        userDao.deleteUser(48);
    }
    @Test
    public void testFindOne(){
        User  user = userDao.findById(50);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List <User> byName = userDao.findByName("%王%");
        for (User user : byName) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5.执行查询一个方法
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }
}

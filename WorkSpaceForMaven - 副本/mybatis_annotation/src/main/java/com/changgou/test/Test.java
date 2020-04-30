package com.itheima.test;

import com.itheima.beans.Account;
import com.itheima.beans.User;
import com.itheima.dao.AccountDaolcl;
import com.itheima.dao.UserDaolcl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDaolcl userDaolcl;
    private AccountDaolcl accountDaolcl;
    private InputStream in;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDaolcl=sqlSession.getMapper(UserDaolcl.class);
        accountDaolcl=sqlSession.getMapper(AccountDaolcl.class);

    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @org.junit.Test
    public void fun01(){
        List<User> all = userDaolcl.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public void fun02(){
        User user = new User();
        user.setId(57);
        user.setUsername("mybatis annotation update");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDaolcl.saveUser(user);
    }
    @org.junit.Test
    public void delete(){
        userDaolcl.deleteUser(58);
    }
    @org.junit.Test
    public void testFindOne(){
        User user = userDaolcl.findById(59);
        System.out.println(user);
    }
    @org.junit.Test
    public  void testFindByName(){
//        List<User> users = userDao.findUserByName("%mybatis%");
        List<User> users = userDaolcl.findUserByName("mybatis");
        for(User user : users){
            System.out.println(user);
        }
    }
    @org.junit.Test
    public void testFindTotal(){
        int total = userDaolcl.findTotalUser();
        System.out.println(total);
    }
    @org.junit.Test
    public void findByNameAndSex() throws Exception{
        String username = "%王%";
        String sex = "男";
        List<User> byNameAndSex = userDaolcl.findByNameAndSex(username, sex);
        for (User nameAndSex : byNameAndSex) {
            System.out.println(nameAndSex);
        }
    }
    @org.junit.Test
    public void findByNameAndSex2() throws Exception{
        String username = "%王%";
        String sex = "男";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name",username);
        map.put("sex",sex);
        List<User> byNameAndSex = userDaolcl.findByNameAndSex2(map);
        for (User nameAndSex : byNameAndSex) {
            System.out.println(nameAndSex);
        }
    }
    @org.junit.Test
    public void testFindAllAccount(){
        List<Account> list = accountDaolcl.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @org.junit.Test
    public void testFindAll(){
        List<User> all = userDaolcl.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public void testFindAccountUser2(){
        List<Account> allAccountUser2 = accountDaolcl.findAllAccountUser2();
        for (Account account : allAccountUser2) {
            System.out.println(account);
        }
    }
}

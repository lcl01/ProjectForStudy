package com.health.dao.impl;

import com.health.beans.QueryVo;
import com.health.beans.User02;
import com.health.beans.User03;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl  {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User02> findAll() {
        // 根据SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 调用SqlSession中的方法，实现查询列表
        List<User02> list = sqlSession.selectList("com.itheima.mapper.UserDao.findAll"); // 参数就是能获取匹配信息的key
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    public void saveUser02(User02 user02) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.mapper.UserDao.saveUser02",user02); // 参数就是能获取匹配信息的key
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

    public void updateUser(User02 user02) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.itheima.mapper.UserDao.updateUser",user02); // 参数就是能获取匹配信息的key
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    public void delete(Integer userid) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.itheima.mapper.UserDao.delete",userid);
        sqlSession.commit();
        sqlSession.close();

    }

    public User02 findById(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        User02 user = sqlSession.selectOne("com.itheima.mapper.UserDao.findById", userId);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    public List<User02> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User02> list = sqlSession.selectList("com.itheima.mapper.UserDao.findByName", name);
        sqlSession.close();
        return list;
    }

    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        int one = sqlSession.selectOne("com.itheima.mapper.UserDao.findTotal");
        sqlSession.close();
        return one;
    }

    public List<User02> findUserByVo(QueryVo vo) {
        return null;
    }

    public List<User03> findAll01() {
        return null;
    }

    public List<User03> findAll02() {
        return null;
    }

    public List<User02> findCondition(User02 user02) {
        return null;
    }
}

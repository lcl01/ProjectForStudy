package com.lcl.dao.impl;

import com.lcl.bean.Account;
import com.lcl.dao.AccountDao;
import com.lcl.utills.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void saveAccount() {
//        System.out.println("AccountDaoImpl 保存了账户");

    }

    public void saveAccount(Account account) {
        try {
            String sql="insert into account1(name,money) values(?,?)";
            runner.update(connectionUtils.getThreadConnection(),sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> findAllAccount() {
        try{
            String sql="select * from account1";
            return runner.query(connectionUtils.getThreadConnection(),sql,new BeanListHandler<Account>(Account.class));

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            String sql="select * from account1 where id = ? ";
            return runner.query(connectionUtils.getThreadConnection(),sql,new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            String sql="update account1 set name=?,money=? where id=?";
            runner.update(connectionUtils.getThreadConnection(),sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            String sql="delete from account1 where id=?";
            runner.update(connectionUtils.getThreadConnection(),sql,accountId);
        } catch (SQLException e) {
           throw new  RuntimeException(e);
        }
    }
    public Account findAccountByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account1 where name = ? ",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

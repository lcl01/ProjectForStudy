package com.changgou.dao.impl;

import com.changgou.beans.Account;
import com.changgou.utils.ConnectionUtils;
import com.changgou.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//@Repository("accountDao")
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    @Qualifier(value = "Runner")
    private QueryRunner queryRunner;
    @Autowired
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            List<Account> query = queryRunner.query("select * from account ", new BeanListHandler<Account>(Account.class));
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            Account query = queryRunner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
            queryRunner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try{
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            queryRunner.update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = queryRunner.query("select * from account where name = ? ",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

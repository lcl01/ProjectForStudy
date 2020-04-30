package com.changgou.dao.impl;

import com.changgou.beans.Account;
import com.changgou.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    @Qualifier(value = "runner")
    private QueryRunner queryRunner;
    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            Account query = queryRunner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), id);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Account account) {
        try {
            int update = queryRunner.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            int update = queryRunner.update("delete from account where id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            int update = queryRunner.update("update account set name=?,money=? where id==?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

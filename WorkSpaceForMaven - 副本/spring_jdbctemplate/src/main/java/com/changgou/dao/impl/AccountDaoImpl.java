package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Autowired // 放置到属性上，也可以放置到set方法上（将spring容器中创建的对象，通过set方法的形参传递给该方法）
    private DataSource dataSource;
    public void setDi(DataSource dataSource){
        super.setDataSource(dataSource);
    }
//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public Account findAccountById(Integer accountId) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);

        return list.isEmpty()? null:list.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }
}

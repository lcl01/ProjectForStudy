package com.lcl.service.impl;

import com.lcl.bean.Account;
import com.lcl.dao.AccountDao;
import com.lcl.dao.impl.AccountDaoImpl;
import com.lcl.factory.BeanFactory;
import com.lcl.service.AccountService;
import com.lcl.utills.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("accountService")
//@Scope("singleton")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl() {
        System.out.println("构造方法...");
    }
//    @PostConstruct
//    public void init(){
//        System.out.println("初始化");
//    }
//    @PreDestroy
//    public void destroy(){
//        System.out.println("销毁");
//    }
    //    public AccountServiceImpl() {
//        System.out.println("对象创建了");
//    }
//    @Value(value = "张鑫")
    private String name;
//    @Value(value = "18")
//    private Integer age;
    public void saveAccount(Account account) {
        // int i = 1; // 单例模式需要设置局部变量
//        System.out.println("AccountServiceImpl 保存了账户");
//       / System.out.println("name:" + name + "age:" + age);
        accountDao.saveAccount(account);
    }

    public List<Account> findAllAccount() {
        try {
            txManager.beiginTransaction();
            List <Account> allAccount = accountDao.findAllAccount();
            txManager.commit();
            return allAccount;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        }
        finally {
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            txManager.beiginTransaction();
            Account accountById = accountDao.findAccountById(accountId);
            txManager.commit();
            return accountById;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        }
        finally {
            txManager.release();
        }

    }
    public Account findAccountByName(String accountName) {
        try {
            txManager.beiginTransaction();
            Account accountByName = accountDao.findAccountByName(accountName);
            txManager.commit();
            return accountByName;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        }
        finally {
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            txManager.beiginTransaction();
            accountDao.updateAccount(account);
            txManager.commit();

        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        }
        finally {
            txManager.release();
        }

    }

    public void deleteAccount(Integer acccountId) {
        try {
            txManager.beiginTransaction();
            accountDao.deleteAccount(acccountId);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void transfer(String sourName, String targetName, Float money) {
        try {
            txManager.beiginTransaction();
            System.out.println("transfer");
            Account source = accountDao.findAccountByName(sourName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
//            int i= 1/0;
            accountDao.updateAccount(target);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            e.printStackTrace();

        }finally {
            txManager.release();
        }
    }
}

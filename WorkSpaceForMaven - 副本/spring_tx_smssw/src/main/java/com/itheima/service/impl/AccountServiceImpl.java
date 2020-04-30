package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    // 注入事务管理的模板
//    private TransactionTemplate transactionTemplate;

//    public TransactionTemplate getTransactionTemplate() {
//        return transactionTemplate;
//    }

//    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
//        this.transactionTemplate = transactionTemplate;
//    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void transfer(final String sourceName, final String targetName, final Float money) {
        System.out.println("transfer....");
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                System.out.println(transactionStatus.isNewTransaction() +  "     "+transactionStatus.isCompleted());
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

        int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
//    }
//});
    }
}

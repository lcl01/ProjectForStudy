import com.itheima.ssm.dao.AccountDao;
import com.itheima.ssm.domain.Account;
import com.itheima.ssm.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Test {
    @org.junit.Test
    public void Fun01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.findAll();
    }
    @org.junit.Test
    public void fun02() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        sqlSession.close();
        in.close();


    }
    @org.junit.Test
    public void testSave() throws Exception {
        Account account = new Account();
        account.setName("小菲");
        account.setMoney(400d);

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        accountDao.saveAccount(account);

        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        in.close();
    }
    @org.junit.Test
    public void testFindAllSpring() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        List<Account> list = accountDao.findAll();
        for(Account account:list){
            System.out.println(account);
        }
    }

}

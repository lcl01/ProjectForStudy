import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        JdbcTemplate jdbcTemplate =  applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
//        jdbcTemplate.execute("insert into account(name,money)values('eee',2222)");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
        accountById.setMoney(1000f);
        accountDao.updateAccount(accountById);
    }
}

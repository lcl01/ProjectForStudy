import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//        AccountDao accountDao = applicationContext.getBean("accountDao01", AccountDao.class);
//        accountDao.saveAccount();
        AccountService accountService =applicationContext.getBean("accountService",AccountService.class);
        accountService.saveAccount();

applicationContext.close();
    }
}

import com.changgou.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop_huanrao {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.deleteAccount();
        accountService.updateAccount(1);
        accountService.saveAccount(); }
}

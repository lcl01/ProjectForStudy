import com.changgou.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.saveAccount();
        accountService.updateAccount(1);
        accountService.deleteAccount();
    }
}

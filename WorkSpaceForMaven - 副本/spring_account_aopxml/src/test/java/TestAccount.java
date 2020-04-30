import com.changgou.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("aaa","bbb",100f);

    }
}

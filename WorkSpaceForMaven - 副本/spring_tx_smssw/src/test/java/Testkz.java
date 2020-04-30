import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testkz {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("aaa","bbb",100f);
    }
}

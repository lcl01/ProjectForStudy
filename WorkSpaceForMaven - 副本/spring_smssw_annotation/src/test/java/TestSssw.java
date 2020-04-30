import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSssw {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("bbb","aaa",100f);
    }
}

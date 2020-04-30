import com.lcl.ssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
    @Test
    public void testService(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService accountService =(AccountService) ac.getBean("accountService");
        accountService.findAll();
    }
}

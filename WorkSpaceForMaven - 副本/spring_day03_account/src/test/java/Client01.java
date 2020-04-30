import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Client01 {
//    @Autowired
//    private AccountService accountService;
//    @Test
//    public void fun01(){
//        accountService.transfer("aaa","bbb",10f);
//    }
public static void main(String[] args) {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = ac.getBean("accountService", AccountService.class);
    accountService.transfer("aaa","bbb",40f);
}
}
                              
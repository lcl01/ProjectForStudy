import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

//    private  static ApplicationContext ac2;
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ac2=new FileSystemXmlApplicationContext("d:/applicationContext");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.saveAccount();

        AccountService accountService1 = (AccountService) ac.getBean("accountService01");
        accountService1.saveAccount();
        System.out.println(accountService1);
        ac.close();

    }
}

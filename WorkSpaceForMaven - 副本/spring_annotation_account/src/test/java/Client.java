import com.itheima.beans.Account;
import com.itheima.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
        Account accountById = accountService.findAccountById(3);
        System.out.println(accountById);
        ac.close();
    }
}

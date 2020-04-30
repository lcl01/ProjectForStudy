import com.changgou.beans.Account;
import com.changgou.config.SpringConfiguration;
import com.changgou.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);

    }
}

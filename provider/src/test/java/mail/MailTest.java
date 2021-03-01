package mail;

import com.example.provider.ProviderApplication;
import com.example.provider.service.mail.SendMailService;
import com.example.provider.uitl.JavaMailUtils;
import com.example.provider.uitl.TimeProfiler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author songbo
 * @Date 2021/2/27 15:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class MailTest {

    @Resource
    private SendMailService sendMailService;

    @Test
    public void test1() {
        try {
            JavaMailUtils.sendMail("测试文本邮件", "邮件内容", "chuziyu@aukeys.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            TimeProfiler.begin();
            sendMailService.sendMail("测试带附件文本邮件", "邮件内容", "320870248@qq.com");
            System.out.println("耗时：" + TimeProfiler.endSeconds() + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

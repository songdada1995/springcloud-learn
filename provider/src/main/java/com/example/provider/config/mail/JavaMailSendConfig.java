package com.example.provider.config.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @Author songbo
 * @Date 2021/2/27 16:54
 * @Version 1.0
 */
@Configuration
public class JavaMailSendConfig {

    @Resource
    private MailProperties mailProperties;

    @Bean
    @ConditionalOnMissingBean
    public JavaMailSenderImpl javaMailSenderImpl() throws GeneralSecurityException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");// 开启debug调试
        properties.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证
        properties.put("mail.smtp.port", mailProperties.getPort());// 端口号
        properties.setProperty("mail.smtp.host", mailProperties.getHost());// 设置邮件服务器主机名
        properties.setProperty("mail.transport.protocol", mailProperties.getProtocol()); // 发送邮件协议名称

        /**SSL认证，注意腾讯邮箱是基于SSL加密的，所以需要开启才可以使用**/
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        // 设置是否使用ssl安全连接（一般都使用）
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        sender.setJavaMailProperties(properties);
        sender.setHost(mailProperties.getHost());
        sender.setPort(mailProperties.getPort());
        sender.setUsername(mailProperties.getUsername());
        sender.setPassword(mailProperties.getPassword());
        sender.setProtocol(mailProperties.getProtocol());

        return sender;
    }

}

package com.example.provider.uitl;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * @Author songbo
 * @Date 2021/2/27 15:13
 * @Version 1.0
 */
public class JavaMailUtils {

    private static String mailHost = "smtp.qq.com";

    private static int port = 465;

    // 发件人
    private static String username = "1152745700@qq.com";

    // 授权码
    private static String password = "lsulivnawjcqjfda";

    private static String protocol = "smtp";

    public static void sendMail(String emailTitle, String emailContent, String receiveEmailAddress)
            throws GeneralSecurityException, MessagingException, IOException {
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");// 开启debug调试
        props.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证
        props.put("mail.smtp.port", port);// 端口号
        props.setProperty("mail.smtp.host", mailHost);// 设置邮件服务器主机名
        props.setProperty("mail.transport.protocol", protocol); // 发送邮件协议名称

        /**SSL认证，注意腾讯邮箱是基于SSL加密的，所以需要开启才可以使用**/
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        // 设置是否使用ssl安全连接（一般都使用）
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        // 创建会话
        Session session = Session.getInstance(props);

        // 获取邮件对象
        // 发送的消息，基于观察者模式进行设计的
        Message msg = new MimeMessage(session);

        // 设置邮件标题
        msg.setSubject(emailTitle);

        StringBuilder builder = new StringBuilder();
        builder.append("\n" + emailContent);
        // 设置显示的发件时间
        msg.setSentDate(new Date());
        // 设置邮件内容
        msg.setText(builder.toString());

        // 设置发件人邮箱
        // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        msg.setFrom(new InternetAddress(username, "宋波", "UTF-8"));

        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户，密码不是自己QQ邮箱的密码，而是在开启SMTP服务时所获取到的授权码
        // connect(host, user, password)
        transport.connect(mailHost, username, password);

        //发送邮件
        transport.sendMessage(msg, new Address[]{new InternetAddress(receiveEmailAddress)});
        //将该邮件保存到本地
        OutputStream out = new FileOutputStream("MyEmail.eml");
        msg.writeTo(out);
        out.flush();
        out.close();

        transport.close();
    }

}

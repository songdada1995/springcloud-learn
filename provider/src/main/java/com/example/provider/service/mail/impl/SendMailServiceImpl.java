package com.example.provider.service.mail.impl;

import com.example.provider.config.mail.MailProperties;
import com.example.provider.service.mail.SendMailService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @Author songbo
 * @Date 2021/2/27 16:29
 * @Version 1.0
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Resource
    private JavaMailSenderImpl javaMailSender;
    @Resource
    private MailProperties mailProperties;

    @Override
    public void sendMail(String emailTitle, String emailContent, String receiveEmailAddress) throws MessagingException {
        // 简单邮件
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(mailProperties.getUsername());
//        simpleMailMessage.setTo(receiveEmailAddress);
//        simpleMailMessage.setSubject(emailTitle);
//        simpleMailMessage.setText(emailContent);
//        javaMailSender.send(simpleMailMessage);



        // 复杂邮件，带附件以及正文内容插入图片
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, mailProperties.getDefaultEncoding());
        messageHelper.setFrom(mailProperties.getUsername());
        messageHelper.setTo(receiveEmailAddress);
        messageHelper.setSubject(emailTitle);
        messageHelper.setText(emailContent + "\n" + "<h1>图片..<img src=\"cid:cat\"/></h1>", true);
        messageHelper.setSentDate(new Date());
        FileSystemResource fsr = new FileSystemResource(new File("F:\\desk_pic\\cat.jpg"));
        messageHelper.addInline("cat", fsr);
        messageHelper.addAttachment("附件.zip", new File("E:\\Amazon差异数据-18.zip"));
        javaMailSender.send(mimeMessage);

    }

}

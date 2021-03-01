package com.example.provider.service.mail;

import javax.mail.MessagingException;

/**
 * @Author songbo
 * @Date 2021/2/27 16:29
 * @Version 1.0
 */
public interface SendMailService {

    void sendMail(String emailTitle, String emailContent, String receiveEmailAddress) throws MessagingException;

}

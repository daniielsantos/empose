package com.empose.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Properties;
@Service
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "spring.mail", name = "host")
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        MailSenderAutoConfiguration as = new MailSenderAutoConfiguration();
        System.out.println("@@@@@@@@@@@@@@@@@@@ "+as.toString());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("daniielsouzapvh@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);



        mailSender.send(message);

        System.out.println("Email enviado com sucesso...");
    }



}

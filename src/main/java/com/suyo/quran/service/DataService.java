package com.suyo.quran.service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class DataService {
    public static ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private final JavaMailSender sender;
    private final Configuration config;

    @Autowired
    public DataService(JavaMailSender sender, Configuration config) {
        this.sender = sender;
        this.config = config;
    }

    @PostConstruct
//    public void sendMail(MailData mailData) {
    public void sendMail() {
        MimeMessage message = sender.createMimeMessage();
        try {
            Map<String, Object> gmailMessage = new HashMap<>();
            gmailMessage.put("username", "mailData.getUsername()");
            int max = 999999;
            int min = 100000;
            String randomNumber = String.valueOf(new Random().nextInt(max + 1 - min) + min);
            gmailMessage.put("code", randomNumber.substring(0, 3) + " " + randomNumber.substring(3));
            gmailMessage.put("img", "https://42f2671d685f51e10fc6-b9fcecea3e50b3b59bdc28dead054ebc.ssl.cf5.rackcdn.com/illustrations/Subscriber_re_om92.svg");
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(config.getTemplate("codePassword.ftl"), gmailMessage);
            helper.setTo("sulaymon1w@gmail.com");
            helper.setText(html, true);
            helper.setSubject("o`sha gap");
            helper.setFrom("sulaymon1w@gmail.com");
            sender.send(message);
        } catch (MessagingException | IOException | TemplateException e) {
            e.fillInStackTrace();
        }
    }
}

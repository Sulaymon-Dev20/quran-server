package com.suyo.quran.service;

import com.suyo.quran.models.MailData;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataService {
    public static ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private final JavaMailSender sender;
    private final Configuration config;

    public void sendMail(MailData mailData) {
        MimeMessage message = sender.createMimeMessage();
        try {
            Map<String, Object> gmailMessage = new HashMap<>();
            gmailMessage.put("username", mailData.getMail());
            gmailMessage.put("code", mailData.getCode());
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(config.getTemplate("codePassword.ftl"), gmailMessage);
            helper.setTo(mailData.getMail());
            helper.setText(html, true);
            helper.setSubject("Register");
            helper.setFrom("sulaymon1w@gmail.com");
            sender.send(message);
        } catch (MessagingException | IOException | TemplateException e) {
            e.fillInStackTrace();
        }
    }
}

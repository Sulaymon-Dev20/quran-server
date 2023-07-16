package com.suyo.quran.service;

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

    public void sendMail(String email, String code) {
        MimeMessage message = sender.createMimeMessage();
        try {
            Map<String, Object> gmailMessage = new HashMap<>();
            gmailMessage.put("username", email);
            gmailMessage.put("code", code);
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(config.getTemplate("codePassword.ftl"), gmailMessage);
            helper.setTo(email);
            helper.setText(html, true);
            helper.setSubject("Register");
            helper.setFrom("sulaymon1w@gmail.com");
            sender.send(message);
        } catch (MessagingException | IOException | TemplateException e) {
            e.fillInStackTrace();
        }
    }
}

package com.suyo.quran.service;

import com.suyo.quran.models.EmailEnum;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class DataService {
    public static ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private final JavaMailSender sender;

    @SneakyThrows
    public static String getTemplate(String path) {
        return new String(Objects.requireNonNull(classloader.getResourceAsStream(path)).readAllBytes());
    }

    @SneakyThrows
    public static String getTemplate(String path, Map<String, Object> replace) {
        String result = new String(Objects.requireNonNull(classloader.getResourceAsStream(path)).readAllBytes());
        for (Map.Entry<String, Object> item : replace.entrySet()) {
            result = result.replace("${" + item.getKey() + "}", item.getValue().toString());
        }
        return result;
    }

    public void sendMail(String email, String code, Timestamp authenticatedTime) {
        MimeMessage message = sender.createMimeMessage();
        try {
            Map<String, Object> gmailMessage = new HashMap<>();
            gmailMessage.put("timeZone", TimeZone.getDefault().getID());
            gmailMessage.put("code", code);
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            final String template = getTemplate("templates/codePassword.html", gmailMessage);
            helper.setTo(email);
            helper.setText(template, true);
            helper.setSubject("Register");
            helper.setFrom("sulaymon1w@gmail.com");
            sender.send(message);
        } catch (MessagingException e) {
            e.fillInStackTrace();
        }
    }
}

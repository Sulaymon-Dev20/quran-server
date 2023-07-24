package com.suyo.quran.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public void sendMail(String email, String code) {
        MimeMessage message = sender.createMimeMessage();
        try {
            Map<String, Object> gmailMessage = new HashMap<>();
            gmailMessage.put("username", email);
            gmailMessage.put("code", code);
//            gmailMessage.put("url", "http://localhost:6236/");
            gmailMessage.put("url", "https://c03b-82-215-114-164.ngrok-free.app/");
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            final String template = getTemplate("templates/index.html", gmailMessage);
//            getTemplate("templates/forgetPassword.html", gmailMessage);
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

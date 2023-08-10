package com.suyo.quran.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.suyo.quran.service.DataService.getTemplate;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender sender;
    public static final String forgetPasswordMail = "templates/codePassword.html";
    public static final String welcomeMail = "templates/codePassword.html";
    public static final String shutdownMail = "templates/codePassword.html";
    public static final String sendCodeMail = "templates/codePassword.html";

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMail(String email, String mailFile, Map<String, Object> gmailMessage) {
        new Thread(() -> {
            MimeMessage message = sender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
                final String template = getTemplate(mailFile, gmailMessage);
                helper.setTo(email);
                helper.setText(template, true);
                helper.setSubject("Register");
                helper.setFrom(fromMail);
                sender.send(message);
            } catch (MessagingException e) {
                e.fillInStackTrace();
            }
        }).start();
    }
}

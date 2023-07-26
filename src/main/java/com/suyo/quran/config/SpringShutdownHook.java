package com.suyo.quran.config;

import com.suyo.quran.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Log4j2
@Component
@RequiredArgsConstructor
public class SpringShutdownHook implements DisposableBean {

    private final MailService mailService;

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Value("${spring.application.shutdown.notification:false}")
    private Boolean isLive;

    @Value("${spring.application.version:-}")
    private String applicationVersion;

    @Value("${spring.telegram.bot.token}")
    private String telegramToken;

    @Value("${spring.telegram.root.id}")
    private String telegramRootId;

    @Override
    public void destroy() {
        if (isLive) {
            notificationEmail();
            notificationTelegram();
        }
    }

    private void notificationTelegram() {
        String uri = "https://api.telegram.org/bot?/sendMessage".replace("?", telegramToken);
        final Map<String, Object> requestBody = Map.of("chat_id", telegramRootId, "disable_notification", true, "parse_mode", "html", "text", "nima bovotti jgar");
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, new HttpHeaders());
        try {
            new RestTemplate().exchange(uri, HttpMethod.POST, entity, Object.class);
            log.warn("🌋 The information about the project's death has been sent to Boss`s Telegram");
        } catch (Exception e) {
            log.error("🦥 We was`t able to tell you boss 🫣");
        }
    }

    private void notificationEmail() {
        mailService.sendMail("sulaymon1w@gmail.com", MailService.shutdownMail, Collections.emptyMap());
        log.warn("🔥 The information about the project's death has been sent to Boss`s email");
    }
}
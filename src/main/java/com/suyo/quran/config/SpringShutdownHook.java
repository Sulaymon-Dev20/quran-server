package com.suyo.quran.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Log4j2
@Component
public class SpringShutdownHook implements DisposableBean {

    @Override
    public void destroy() {
        String uri = "https://api.telegram.org/bot5245147236:AAFCAZDVUO1aXqkCzBBeq-MGJjwlKmupTg0/sendMessage";
        final Map<String, Object> requestBody = Map.of("chat_id", "1683666349", "disable_notification", true, "parse_mode", "html", "text", "nima bovotti jgar");
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, new HttpHeaders());
        try {
            new RestTemplate().exchange(uri, HttpMethod.POST, entity, Object.class);
            log.warn("🌋 time of death");
        } catch (Exception e) {
            log.error("🦥 We was`t able to tell you boss 🫣");
        }
    }
}

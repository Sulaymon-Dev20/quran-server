package com.suyo.quran.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "spring.telegram.bot")
@Configuration("telegramProperties")
@Data
public class TelegramProperties {
    String token;
    String username;
    String rootId;
    String groupId;
}

package com.suyo.quran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:properties/application.properties"),
    @PropertySource("classpath:properties/application-datasource.properties"),
    @PropertySource("classpath:properties/application-mail.properties"),
    @PropertySource("classpath:properties/application-jpa.properties"),
    @PropertySource("classpath:properties/application-security.properties"),
    @PropertySource("classpath:properties/application-swagger.properties"),
    @PropertySource("classpath:properties/application-telegram.properties"),
    @PropertySource("classpath:properties/application-cloud.properties"),
})
@ComponentScan(basePackages = {"com.suyo.quran", "org.telegram.telegrambots"})
@EnableDiscoveryClient
public class QuranApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuranApplication.class, args);
    }
}

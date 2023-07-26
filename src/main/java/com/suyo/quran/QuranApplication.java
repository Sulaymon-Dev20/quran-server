package com.suyo.quran;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
})
public class QuranApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(QuranApplication.class, args);
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(QuranApplication.class, args.getSourceArgs());
        });
        thread.setDaemon(false);
        thread.start();
    }
}

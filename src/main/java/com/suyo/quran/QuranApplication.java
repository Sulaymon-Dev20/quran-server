package com.suyo.quran;

import com.suyo.quran.util.PageContent;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableScheduling
public class QuranApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        System.out.println(PageContent.titleList.get(new Random().nextInt(PageContent.titleList.size())));
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

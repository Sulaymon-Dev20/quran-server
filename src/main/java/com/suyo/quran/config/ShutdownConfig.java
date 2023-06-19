package com.suyo.quran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShutdownConfig {

    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean();
    }

    static class TerminateBean {
        public void onDestroy() throws Exception {
            System.out.println("project down bro :((");
            System.out.println(new String(Runtime.getRuntime().exec("curl -X POST https://textbelt.com/text --data-urlencode phone='+998909476154' --data-urlencode message='Assalamu-alaykum-Xojiaka-project-o`chib-qoldiyov:))' -d key=textbelt").getInputStream().readAllBytes()));
        }
    }
}

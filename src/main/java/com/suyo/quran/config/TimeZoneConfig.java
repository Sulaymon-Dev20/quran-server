//package com.suyo.quran.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import java.util.TimeZone;
//
//@Component
//@EnableScheduling
//@RequiredArgsConstructor
//public class TimeZoneConfig {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return args -> jdbcTemplate.update("SET TIMEZONE TO '" + TimeZone.getDefault().getID() + "'");
//    }
//}

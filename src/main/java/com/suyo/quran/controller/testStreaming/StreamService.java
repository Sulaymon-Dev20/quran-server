//package com.suyo.quran.controller.testStreaming;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class StreamService {
//
//    private final ResourceLoader resourceLoader;
//
//    public Resource getVideo(String title) {
//        String FORMAT = "classpath:videos/%s.mp4";
//        return resourceLoader.getResource(String.format(FORMAT, title));
//    }
//}

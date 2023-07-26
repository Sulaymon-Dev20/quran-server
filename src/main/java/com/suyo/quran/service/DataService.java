package com.suyo.quran.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DataService {
    public static ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    @SneakyThrows
    public static String getTemplate(String path) {
        return new String(Objects.requireNonNull(classloader.getResourceAsStream(path)).readAllBytes());
    }

    @SneakyThrows
    public static String getTemplate(String path, Map<String, Object> replace) {
        String result = new String(Objects.requireNonNull(classloader.getResourceAsStream(path)).readAllBytes());
        for (Map.Entry<String, Object> item : replace.entrySet()) {
            result = result.replace("${" + item.getKey() + "}", item.getValue().toString());
        }
        return result;
    }
}

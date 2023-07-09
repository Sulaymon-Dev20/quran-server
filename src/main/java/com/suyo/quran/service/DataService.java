package com.suyo.quran.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public static ClassLoader classloader = Thread.currentThread().getContextClassLoader();
}

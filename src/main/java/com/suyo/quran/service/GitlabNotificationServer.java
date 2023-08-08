package com.suyo.quran.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/git")
public class GitlabNotificationServer {

    @PostMapping("/test")
    public void onUpdateReceived(@RequestBody Map<String, Object> map) {

    }
}

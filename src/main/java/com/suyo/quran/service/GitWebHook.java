package com.suyo.quran.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/git")
@RequiredArgsConstructor
public class GitWebHook {

    private final GitWebHookService hookService;

    @PostMapping("/telegram")
    public void sendToTelegram(@RequestHeader(name = "X-Gitlab-Token") String token, @RequestBody Map<String, Object> data) {
        new Thread(() -> hookService.sendToTelegram(token, data)).start();
    }
}

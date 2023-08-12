package com.suyo.quran.controller.auth;

import com.suyo.quran.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@Validated
@RequiredArgsConstructor
@Tag(name = "authTag", description = "authTagDescription")
public class QuizController {
    private final QuizService service;
}

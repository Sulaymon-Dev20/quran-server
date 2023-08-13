package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.Quiz;
import com.suyo.quran.models.auth.Response;
import com.suyo.quran.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@Validated
@RequiredArgsConstructor
@Tag(name = "authTag", description = "authTagDescription")
public class QuizController {
    private final QuizService service;

    @PostConstruct
    public Response saveAll(@Valid @RequestBody List<Quiz> quiz) {
        return service.saveAll(quiz);
    }
}

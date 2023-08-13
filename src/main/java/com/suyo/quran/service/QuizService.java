package com.suyo.quran.service;

import com.suyo.quran.entities.Quiz;
import com.suyo.quran.models.auth.Response;
import com.suyo.quran.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public Response saveAll(List<Quiz> quiz) {
        quizRepository.saveAll(quiz);
        return new Response();
    }
}

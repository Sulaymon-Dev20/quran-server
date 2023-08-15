package com.suyo.quran.service;

import com.suyo.quran.entities.Quiz;
import com.suyo.quran.entities.enums.Language;
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

    public List<Quiz> getPageable(Language language, Integer pageNumber, Integer sizeNumber) {
        return quizRepository.findAllByPageable(pageNumber, sizeNumber).stream().peek(item -> {
            item.getQuestion().getLanguage(language);
            item.getOptions().getOption1().getLanguage(language);
            item.getOptions().getOption2().getLanguage(language);
            item.getOptions().getOption3().getLanguage(language);
            item.getOptions().getOption4().getLanguage(language);
        }).toList();
    }
}

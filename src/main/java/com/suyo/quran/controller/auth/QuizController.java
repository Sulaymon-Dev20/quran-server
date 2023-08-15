package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.Quiz;
import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.auth.Response;
import com.suyo.quran.service.QuizService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.suyo.quran.util.SwaggerDoc.languageParameter;
import static com.suyo.quran.util.SwaggerDoc.versesGetChapterNumberParameter;

@RestController
@RequestMapping("/api/quiz")
@Validated
@RequiredArgsConstructor
@Tag(name = "asdf", description = "2", externalDocs = @ExternalDocumentation(description = "Auth JWT Required", url = "https://jwt.io/introduction"))
public class QuizController {
    private final QuizService service;

    @PostMapping
    public Response saveAll(@Valid @RequestBody List<Quiz> quiz) {
        return service.saveAll(quiz);
    }

    @GetMapping
    public List<Quiz> getPageable(
        @Parameter(description = languageParameter)
        @RequestParam(defaultValue = "ALL")
            Language language,
        @Parameter(description = versesGetChapterNumberParameter)
        @RequestParam(name = "page", defaultValue = "1")
        @Min(value = 1, message = "min pageNumber is 1")
            Integer pageNumber,
        @Parameter(description = versesGetChapterNumberParameter)
        @Min(value = 3, message = "min sizeNumber is 3")
        @RequestParam(name = "size", defaultValue = "999999")
            Integer sizeNumber) {
        return service.getPageable(language, pageNumber, sizeNumber);
    }
}

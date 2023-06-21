package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.service.ChapterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/chapter")
@Validated
public class ChapterController {


    final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/{language}")
    public Response getChapterListByLanguage(@PathVariable Language language) {
        return chapterService.getChapterListByLanguage(language);
    }

    @GetMapping("/all/{language}")
    public Response getChapterSource(@PathVariable Language language) {
        return chapterService.getChapterByLanguage(language);
    }

    @GetMapping("/{language}/{number}")
    public Response getChapterByLanguage(@NotNull @PathVariable Language language, @PathVariable("number") @Min(1) @Max(114) Integer chapterNumber) {
        return chapterService.getChapterByLanguage(language, chapterNumber);
    }
}

package com.suyo.quran.controller;

import com.suyo.quran.models.Response;
import com.suyo.quran.service.ChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {


    final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/")
    public Response getChapterByLanguage() {
        return new Response();
    }
}

package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.chapter.Chapter;
import com.suyo.quran.service.ChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chapter")
@Validated
@Tag(name = "Chapter Controller 2", description = "Operations ```asdf``` pertaining to manager blood donors in the application")
public class ChapterController {

    final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<Chapter> getChapterList(@Parameter(name = "language", description = "the user to create", example = "DEFAULT") @RequestParam(defaultValue = "DEFAULT") Language language) {
        return chapterService.getChapterListByLanguage(language);
    }
}

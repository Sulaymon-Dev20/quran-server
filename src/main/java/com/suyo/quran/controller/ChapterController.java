package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.service.ChapterService;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chapter")
@Validated
@Api(description = "Operations pertaining to manager blood donors in the application")
public class ChapterController {

    final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    @ApiOperation(value = "View a list of available products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "<h1>asdfasdfasdfasdf</h1>You are not authorized to view the resource")
    })
    public Response getChapterList(@ApiParam(value = "the user to create", defaultValue = "DEFAULT") @RequestParam(defaultValue = "DEFAULT") Language language) {
        return chapterService.getChapterListByLanguage(language);
    }
}

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
    @ApiOperation(value = "View a list of available products", notes = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "model ``` asdf asdf``` <br/> "),
    })
    public Response getChapterList(@ApiParam(value = "the user to create", defaultValue = "DEFAULT") @RequestParam(defaultValue = "DEFAULT") Language language) {
        return chapterService.getChapterListByLanguage(language);
    }
}

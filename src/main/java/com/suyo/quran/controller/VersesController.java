package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.service.VersesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/verses")
@Validated
@Api(description = "Operations pertaining to manager blood donors in the application")
public class VersesController {

    final VersesService versesService;

    public VersesController(VersesService service) {
        this.versesService = service;
    }

    @GetMapping
    public Response getChapterSource(@RequestParam(defaultValue = "DEFAULT") Language language) {
        return versesService.getChapterByLanguage(language);
    }

    @GetMapping("/{number}")
    public Response getChapter(
            @ApiParam(value = "the user to create", defaultValue = "DEFAULT")
            @RequestParam(defaultValue = "DEFAULT")
            Language language,
            @ApiParam(value = "the user to create", required = true)
            @Min(value = 1, message = "min Chapter number is 1")
            @Max(value = 114, message = "max Chapter number is 114")
            @PathVariable("number")
            Integer chapterNumber) {
        return versesService.getChapterByLanguage(language, chapterNumber);
    }
}

package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.models.verses.Verse;
import com.suyo.quran.service.VersesService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/verses")
@Validated
@Api(description = "Operations pertaining to manager blood donors in the application")
public class VersesController {

    final VersesService versesService;

    public VersesController(VersesService service) {
        this.versesService = service;
    }

    @GetMapping()
    @ApiOperation(value = "View a list of available products", responseContainer = "application/json", notes = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "model ``` asdf asdf``` <br/> "),
    })
    public List<List<Verse>> getAllChapter(@RequestParam(defaultValue = "DEFAULT") Language language) {
        return versesService.getAllChapter(language);
    }

    @GetMapping(value = "/{number}")
    @ApiOperation(value = "View a list of available products", notes = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "model ``` asdf asdf``` <br/> "),
    })
    public List<Verse> getChapter(
        @ApiParam(value = "the user to create", defaultValue = "DEFAULT")
        @RequestParam(defaultValue = "DEFAULT")
        Language language,
        @ApiParam(value = "the user to create", required = true)
        @Min(value = 1, message = "min Chapter number is 1")
        @Max(value = 114, message = "max Chapter number is 114")
        @PathVariable("number")
        Integer chapterNumber) {
        return versesService.getChapter(language, chapterNumber);
    }
}

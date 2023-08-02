package com.suyo.quran.controller.nonAuth;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.chapter.Chapter;
import com.suyo.quran.service.ChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/chapter", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = "chapter controller", description = "Operations ```asdf``` pertaining to manager blood donors in the application")
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<Chapter> getChapterList(@Parameter(description = "the user to create") @RequestParam(defaultValue = "ALL") Language language) {
        return chapterService.getChapterListByLanguage(language);
    }
}

package com.suyo.quran.controller.nonAuth;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.chapter.Chapter;
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

import static com.suyo.quran.util.SwaggerDoc.*;

@RestController
@RequestMapping(value = "/api/chapter", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = chapterTag, description = chapterTagDescription)
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    @Operation(summary = chapterGet, description = chapterGetDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<Chapter> getChapterList(@Parameter(description = languageParameter) @RequestParam(defaultValue = "ALL") Language language) {
        return chapterService.getChapterListByLanguage(language);
    }
}

package com.suyo.quran.controller.nonAuth;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.verses.Verse;
import com.suyo.quran.service.VersesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.suyo.quran.util.SwaggerDoc.*;

@RestController
@RequestMapping(value = "/api/verses", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = versesTag, description = versesTagDescription)
public class VersesController {

    private final VersesService versesService;

    @GetMapping
    @Operation(summary = versesGetAllChapter, description = versesGetAllChapterDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<List<Verse>> getAllChapter(@Parameter(description = languageParameter) @RequestParam(defaultValue = "ALL") Language language) {
        return versesService.getAllChapter(language);
    }

    @GetMapping(value = "/{number}")
    @Operation(summary = versesGetChapter, description = versesGetChapterDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<Verse> getChapter(
        @Parameter(description = languageParameter)
        @RequestParam(defaultValue = "ALL")
            Language language,
        @Parameter(description = versesGetChapterNumberParameter, required = true)
        @Min(value = 1, message = "min Chapter number is 1")
        @Max(value = 114, message = "max Chapter number is 114")
        @PathVariable("number")
            Integer chapterNumber) {
        return versesService.getChapter(language, chapterNumber);
    }
}

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
import static com.suyo.quran.util.Utils.paginate;

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
        @ApiResponse(responseCode = "200", description = versesGetAllChapter200),
        @ApiResponse(responseCode = "400", description = versesGetAllChapter400),
    })
    public List<List<Verse>> getAllChapter(@Parameter(description = languageParameter) @RequestParam(defaultValue = "ALL") Language language) {
        return versesService.getAllChapter(language);
    }

    @GetMapping(value = "/{number}")
    @Operation(summary = versesGetChapter, description = versesGetChapterDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = versesGetChapter200),
        @ApiResponse(responseCode = "400", description = versesGetChapter400),
    })
    public List<Verse> getChapter(
        @Parameter(description = languageParameter)
        @RequestParam(defaultValue = "ALL")
            Language language,
        @Parameter(description = versesGetChapterNumberParameter, required = true)
        @Min(value = 1, message = "min Chapter number is 1")
        @Max(value = 114, message = "max Chapter number is 114")
        @PathVariable("number")
            Integer chapterNumber,
        @Parameter(description = versesGetChapterNumberParameter)
        @RequestParam(name = "page", defaultValue = "1")
        @Min(value = 1, message = "min pageNumber is 1")
            Integer pageNumber,
        @Parameter(description = versesGetChapterNumberParameter)
        @Min(value = 3, message = "min sizeNumber is 3")
        @RequestParam(name = "size", defaultValue = "999999")
            Integer sizeNumber) {
        return paginate(versesService.getChapter(language, chapterNumber), pageNumber, sizeNumber);
    }
}

package com.suyo.quran.controller.nonAuth;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.verses.Verse;
import com.suyo.quran.service.VersesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verses")
@Validated
@RequiredArgsConstructor
@Tag(name = "Verses Controller", description = "Operations ```asdf``` pertaining to manager blood donors in the application")
public class VersesController {

    private final VersesService versesService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<List<Verse>> getAllChapter(@RequestParam(defaultValue = "DEFAULT") Language language) {
        return versesService.getAllChapter(language);
    }

    @GetMapping(value = "/{number}", produces = "application/json")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public List<Verse> getChapter(
            @Parameter(name = "language", description = "the user to create", example = "DEFAULT")
            @RequestParam(defaultValue = "DEFAULT")
            Language language,
            @Parameter(description = "the user to create", required = true)
            @Min(value = 1, message = "min Chapter number is 1")
            @Max(value = 114, message = "max Chapter number is 114")
            @PathVariable("number")
            Integer chapterNumber) {
        return versesService.getChapter(language, chapterNumber);
    }
}

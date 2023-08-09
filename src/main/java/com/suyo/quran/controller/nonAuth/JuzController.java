package com.suyo.quran.controller.nonAuth;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.juz.JuzModel;
import com.suyo.quran.service.JuzService;
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
@RequestMapping(value = "/api/juz", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = juzTag, description = juzTagDescription)
public class JuzController {

    private final JuzService juzService;

    @GetMapping
    @Operation(summary = juzGet, description = juzGetDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>", useReturnTypeSchema = true),
        @ApiResponse(responseCode = "404", description = "model ``` asdf asdf``` <br/>", useReturnTypeSchema = true)
    })
    public List<JuzModel> getJuz(@Parameter(description = languageParameter) @RequestParam(defaultValue = "ALL") Language language) {
        return juzService.getJuz(language);
    }
}

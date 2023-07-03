package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.service.JuzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/juz")
@Validated
@Api(produces = "application/json", value = "Operations pertaining to manager blood donors in the application")
public class JuzController {

    final JuzService juzService;

    public JuzController(JuzService juzService) {
        this.juzService = juzService;
    }

    @GetMapping
    @ApiOperation(value = "Create a new donor", nickname = "Sulaymon Yahyo", response = ResponseEntity.class)
    public Response getJuz(@RequestParam(defaultValue = "DEFAULT") Language language) {
        return juzService.getJuz(language);
    }
}

package com.suyo.quran.controller;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.juz.JuzModel;
import com.suyo.quran.service.JuzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/juz")
@Validated
@Api(description = "Operations pertaining to manager blood donors in the application")
public class JuzController {

    final JuzService juzService;

    public JuzController(JuzService juzService) {
        this.juzService = juzService;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a list of available products", notes = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "model ``` asdf asdf``` <br/> "),
    })
    public List<JuzModel> getJuz(@RequestParam(defaultValue = "DEFAULT") Language language) {
        return juzService.getJuz(language);
    }
}

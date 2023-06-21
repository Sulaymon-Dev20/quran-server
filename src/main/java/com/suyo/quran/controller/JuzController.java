package com.suyo.quran.controller;

import com.suyo.quran.models.Response;
import com.suyo.quran.service.JuzService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/juz")
@Validated
public class JuzController {

    final JuzService juzService;

    public JuzController(JuzService juzService) {
        this.juzService = juzService;
    }

    @GetMapping
    public Response getJuz() {
        return juzService.getJuz();
    }
}

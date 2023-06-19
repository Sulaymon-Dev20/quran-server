package com.suyo.quran.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/station")
public class StationController {

    @GetMapping("/")
    private String stationByType() {
        return "service.getStations(status)";
    }
}

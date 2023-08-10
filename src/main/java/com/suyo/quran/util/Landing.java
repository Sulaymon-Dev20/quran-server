package com.suyo.quran.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Landing {

    @GetMapping("/")
    public String landingPage() {
        return "index";
    }
}

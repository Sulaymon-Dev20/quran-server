package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.User;
import com.suyo.quran.security.CurrentUser;
import com.suyo.quran.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String userMe(@CurrentUser User user) {
        return user.getId().toString();
    }
}

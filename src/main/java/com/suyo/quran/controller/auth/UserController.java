package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.ChangePassword;
import com.suyo.quran.models.SetPassword;
import com.suyo.quran.security.CurrentUser;
import com.suyo.quran.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String userMe(@CurrentUser User user) {
        return user.getId().toString();
    }

    @PostMapping("/set/password")
    public ResponseEntity<Object> setUpPassword(@CurrentUser User user, @RequestBody SetPassword password) {
        return ResponseEntity.ok(userService.setPassword(user.getId(), password));
    }

    @PostMapping("/change/password")
    public ResponseEntity<Object> changePassword(@CurrentUser User user, @RequestBody ChangePassword password) {
        return ResponseEntity.ok(userService.changePassword(user.getId(), password));
    }
}

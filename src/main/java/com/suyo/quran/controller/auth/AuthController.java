package com.suyo.quran.controller.auth;

import com.suyo.quran.models.CheckEmailCode;
import com.suyo.quran.security.AuthService;
import com.suyo.quran.security.models.AuthResponse;
import com.suyo.quran.security.models.LoginRequest;
import com.suyo.quran.security.models.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
@Validated
@RequiredArgsConstructor
@Tag(name = "auth controller", description = "Operations ```asdf``` pertaining to manager blood donors in the application")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public Object register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/check/code")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public ResponseEntity<AuthResponse> check(@RequestBody CheckEmailCode request) {
        return ResponseEntity.ok(authService.checkCode(request));
    }

    @PostMapping("/login")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

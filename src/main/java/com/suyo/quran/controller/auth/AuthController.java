package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.auth.CheckEmailCode;
import com.suyo.quran.models.auth.Login;
import com.suyo.quran.models.auth.Register;
import com.suyo.quran.security.AuthService;
import com.suyo.quran.security.JWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = "auth controller", description = "Operations ```asdf``` pertaining to manager blood donors in the application")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public Object register(@Valid @RequestBody Register request) {
        return authService.register(request);
    }

    @PostMapping("/check/code")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public ResponseEntity<JWT> check(@Valid @RequestBody CheckEmailCode request) {
        return ResponseEntity.ok(authService.checkCode(request));
    }

    @PostMapping("/refreshToken")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<JWT> refreshToken(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(authService.refreshToken(user));
    }

    @PostMapping("/login")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    public ResponseEntity<JWT> login(@Valid @RequestBody Login request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

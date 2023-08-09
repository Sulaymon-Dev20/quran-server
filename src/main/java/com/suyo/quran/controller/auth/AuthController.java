package com.suyo.quran.controller.auth;

import com.suyo.quran.models.auth.CheckEmailCode;
import com.suyo.quran.models.auth.Login;
import com.suyo.quran.models.auth.Register;
import com.suyo.quran.security.AuthService;
import com.suyo.quran.security.JWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.links.LinkParameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.suyo.quran.util.SwaggerDoc.*;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = authTag, description = authTagDescription)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = authPostRegister, description = authPostRegisterDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public Object register(@Valid @RequestBody Register request) {
        return authService.register(request);
    }

    @PostMapping("/check/code")
    @Operation(summary = authPostCheckCode, description = authPostCheckCodeDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public JWT check(@Valid @RequestBody CheckEmailCode request) {
        return authService.checkCode(request);
    }

    @PostMapping("/login")
    @Operation(summary = authPostLogin, description = authPostLoginDescription)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public JWT login(@Valid @RequestBody Login request) {
        return authService.login(request);
    }
}

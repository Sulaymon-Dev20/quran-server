package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.auth.SetPassword;
import com.suyo.quran.models.auth.UserInfo;
import com.suyo.quran.security.AuthService;
import com.suyo.quran.security.JWT;
import com.suyo.quran.service.UserService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.suyo.quran.util.SwaggerDoc.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name = userTag, description = userTagDescription, externalDocs = @ExternalDocumentation(description = "Auth JWT Required", url = "https://jwt.io/introduction"))
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    @Operation(summary = userGet, description = userGetDescription, security = {@SecurityRequirement(name = "bearerAuth"), @SecurityRequirement(name = "security_auth")})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = userGet200),
        @ApiResponse(responseCode = "400", description = userGet400),
    })
    public UserInfo userMe(@AuthenticationPrincipal User user) {
        return new UserInfo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getTheme(), user.getBookmarks(), user.getTextSettings(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @PostMapping("/set/password")
    @Operation(summary = userPostPassword, description = userPostPasswordDescription, security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = userPostPassword200),
        @ApiResponse(responseCode = "400", description = userPostPassword400),
    })
    public ResponseEntity<Object> setUpPassword(@AuthenticationPrincipal User user, @Valid @RequestBody SetPassword password) {
        return ResponseEntity.ok(userService.setPassword(user.getId(), password));
    }

    @PostMapping("/refreshToken")
    @Operation(summary = userPostRefreshToken, description = userPostRefreshTokenDescription, security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = userPostRefreshToken200),
        @ApiResponse(responseCode = "400", description = userPostRefreshToken400),
    })
    public JWT refreshToken(@AuthenticationPrincipal User user) {
        return authService.refreshToken(user);
    }
}

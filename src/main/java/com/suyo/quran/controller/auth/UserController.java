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
@Tag(name = userTag, description = userTagDescription, externalDocs = @ExternalDocumentation(description = "Auth JWT Required", url = "#/auth%20controller/register"))
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    @Operation(summary = userGet, description = userGetDescription, security = {@SecurityRequirement(name = "bearerAuth"), @SecurityRequirement(name = "security_auth")})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "model ``` asdf asdf``` <br/>")
    })
    public UserInfo userMe(@AuthenticationPrincipal User user) {
        return new UserInfo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getTheme(), user.getBookmarks(), user.getTextSettings(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @PostMapping("/set/password")
    @Operation(summary = userPost, description = userPostDescription, security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Object> setUpPassword(@AuthenticationPrincipal User user, @Valid @RequestBody SetPassword password) {
        return ResponseEntity.ok(userService.setPassword(user.getId(), password));
    }

    @PostMapping("/refreshToken")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", security = @SecurityRequirement(name = "bearerAuth"))
    public JWT refreshToken(@AuthenticationPrincipal User user) {
        return authService.refreshToken(user);
    }
}

package com.suyo.quran.controller.auth;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.SetPassword;
import com.suyo.quran.models.UserInfo;
import com.suyo.quran.service.UserService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json")
@Validated
@RequiredArgsConstructor
@Tag(name = "user controller", description = "Operations ```asdf``` pertaining to manager blood donors in the application", externalDocs = @ExternalDocumentation(description = "Auth JWT Required", url = "#/auth%20controller/register"))
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", security = {@SecurityRequirement(name = "bearerAuth")})
    public UserInfo userMe(@AuthenticationPrincipal User user) {
        return new UserInfo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getTheme(), user.getBookmarks(), user.getTextSettings(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @PostMapping("/set/password")
    @Operation(summary = "View a list of available products", description = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", security = {@SecurityRequirement(name = "bearerAuth")})
    public ResponseEntity<Object> setUpPassword(@AuthenticationPrincipal User user, @RequestBody SetPassword password) {
        return ResponseEntity.ok(userService.setPassword(user.getId(), password));
    }
}

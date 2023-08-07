package com.suyo.quran.models.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Login Model", description = "login model")
public class Login {
    @Schema(title = "user email", example = "sulaymon1w@gmail.com", description = "user email")
    @NotNull(message = "column required")
    @Email(message = "column must be email address")
    private String email;
    @Schema(title = "User password", example = "mypassword", description = "user password")
    @NotNull(message = "column required")
    private String password;
}

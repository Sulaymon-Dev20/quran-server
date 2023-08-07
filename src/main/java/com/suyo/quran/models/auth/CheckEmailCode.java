package com.suyo.quran.models.auth;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Check Email Code Model", description = "y")
public class CheckEmailCode {
    @Schema(title = "Email Code", example = "999999", description = "email oauth code", required = true)
    @NotNull(message = "column required")
    @Length(min = 6, max = 6, message = "invalid verification min length 6 max length 6")
    @Pattern(regexp = "[0-9]+", message = "column consist of only number")
    private String code;
    @Schema(title = "User Email", example = "sulaymon1w@gmail.com", description = "user email")
    @NotNull(message = "column required")
    @Email(message = "column must be email address")
    private String email;

    public String getCode() {
        return code.replaceAll("[A-z, /-]", "");
    }
}

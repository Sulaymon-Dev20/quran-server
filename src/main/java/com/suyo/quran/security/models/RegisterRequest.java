package com.suyo.quran.security.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Register object", name = "Register fields", description = "there is information of user")
public class RegisterRequest {
    @NotNull
    @Schema(title = "email", example = "sulaymon1w@gmail.com", description = "there shuold be email address then band end service send email short code", required = true)
    private String email;
    @Schema(title = "firstName", example = "SulaymonYahyo", description = "here you can set your firstname")
    private String firstName;
    @Schema(title = "lastName", example = "Ibn Baxodir", description = "here you can set your lastname")
    private String lastName;
}

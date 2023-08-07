package com.suyo.quran.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "JWT model", name = "JWT model", description = "there is information of user")
public class JWT {
    @Schema(title = "Access Token", example = "qjjd1vmgbtWb23fPK4J9ttUQBKpgC6k1yFmnteU+9mlFxcHeC3rJlly8oGBBAIzw", description = "access token")
    private String accessToken;
    @Schema(title = "Refresh Token", example = "qjjd1vmgbtWb23fPK4J9ttUQBKpgC6k1yFmnteU+9mlFxcHeC3rJlly8oGBBAIzw", description = "refresh token")
    private String refreshToken;
    @Schema(title = "Expire Token", example = "864000002123", description = "expire token date")
    private long expireToken;
    @Schema(title = "type ", example = "Bearer ", description = "Auth type")
    private final String type = "Bearer ";
}

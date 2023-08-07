package com.suyo.quran.models.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Error model", description = " model")
public class ErrorField {
    @Schema(title = "Error model", example = "email", description = "prop")
    private String prop;
    @Schema(title = "Error model", example = "column must be email address", description = "mesagge")
    private String message;
}

package com.suyo.quran.models.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Error Response Model", description = "any exception response model")
public class Response {
    @Schema(title = "error message List", example = "[{ \"prop\": \"email\", \"message\": \"column must be email address\" }]", description = "here will be error")
    private List<ErrorField> errorList;
    @Schema(title = "Error Response Model", example = "Not Found", description = "m", deprecated = true)
    @Deprecated
    private String mainMessage;
}

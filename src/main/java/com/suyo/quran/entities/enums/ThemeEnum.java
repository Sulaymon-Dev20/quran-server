package com.suyo.quran.entities.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "Language Model", name = "Language Model", description = "Language all")
public enum ThemeEnum {
    DARK,
    LIGHT,
    AUTO,
    SYSTEM,
}

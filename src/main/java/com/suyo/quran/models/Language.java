package com.suyo.quran.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "Language Model", name = "Language Model", description = "Language all ")
public enum Language {
    ALL, BN, EN, ES, FR, ID, RU, SV, TR, UR, UZ, ZH;
}

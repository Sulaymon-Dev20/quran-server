package com.suyo.quran.models;

public enum Language {
    DEFAULT, BN, EN, ES, FR, ID, RU, SV, TR, UR, UZ, ZH;

    public String getJsonForm() {
        return this.name().toLowerCase() + ".json";
    }
}

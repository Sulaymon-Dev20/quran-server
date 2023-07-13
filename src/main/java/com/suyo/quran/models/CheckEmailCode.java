package com.suyo.quran.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckEmailCode {
    private String code;
    private String email;

    public String getCode() {
        return code.replaceAll("[A-z, /-]", "");
    }
}

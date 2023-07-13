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

    public CheckEmailCode(String code) {
        this.code = code.replaceAll("[A-z,/-]", "");
    }
}

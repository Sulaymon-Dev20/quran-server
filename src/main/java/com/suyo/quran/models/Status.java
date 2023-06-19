package com.suyo.quran.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Integer code;
    private String message;

    public Status(Integer code) {
        this.code = code;
        this.message = HttpStatus.valueOf(code).getReasonPhrase();
    }

    public Status(HttpStatus status) {
        this.code = status.value();
        this.message = status.name();
    }
}

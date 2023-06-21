package com.suyo.quran.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Status status;

    private List<String> errorList;
    private Object data;

    public Response(Status status, Object data) {
        this.status = status;
        this.data = data;
        this.errorList = List.of();
    }
}

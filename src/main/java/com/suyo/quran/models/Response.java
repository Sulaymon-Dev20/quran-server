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
    private List<ErrorsField> errorList;
    private Object data;
}

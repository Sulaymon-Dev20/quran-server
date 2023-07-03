package com.suyo.quran.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "ok asdf jkasldfj asdklf jk jasdf", response = DDDF.class),
        @ApiResponse(code = 201, message = "ok asdf jkasldfj asdklf jk jasdf", response = DDDF.class),
        @ApiResponse(code = 202, message = "ok asdf jkasldfj asdklf jk jasdf", response = DDDF.class),
        @ApiResponse(code = 203, message = "ok asdf jkasldfj asdklf jk jasdf", response = DDDF.class),
})
public @interface GetJuzWithParam {
}

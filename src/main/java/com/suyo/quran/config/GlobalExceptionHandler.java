package com.suyo.quran.config;

import com.suyo.quran.models.auth.ErrorField;
import com.suyo.quran.models.auth.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response handleConstraintViolationException(HttpServletRequest request, Exception ex) {
        return new Response(List.of(new ErrorField("context", ex.getMessage())), request.getServletPath());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response onConstraintValidationException(ConstraintViolationException e) {
        return new Response(e.getConstraintViolations().stream().map(violation -> new ErrorField(violation.getPropertyPath().toString(), violation.getMessage())).toList(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Response(e.getBindingResult().getFieldErrors().stream().map(fieldError -> new ErrorField(fieldError.getField(), Objects.toString(fieldError.getDefaultMessage(), "null"))).toList(), e.getMessage());
    }
}

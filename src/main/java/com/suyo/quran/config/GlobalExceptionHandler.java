package com.suyo.quran.config;

import com.suyo.quran.models.Response;
import com.suyo.quran.models.Status;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleConstraintViolationException(HttpServletRequest request, Exception ex) {
        return new Response(new Status(400), List.of(ex.getMessage()), request.getServletPath());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response onConstraintValidationException(ConstraintViolationException e) {
        Response res = new Response();
        res.setStatus(new Status(400));
        res.setErrorList(e.getConstraintViolations().stream().map(violation -> violation.getPropertyPath().toString() + " " + violation.getMessage()).toList());
        return res;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Response res = new Response();
        res.setStatus(new Status(400));
        res.setErrorList(e.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage()).toList());
        return res;
    }
}

package com.suyo.quran.util;

import com.suyo.quran.models.auth.Response;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class BadController implements ErrorController {

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH}, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Response> handleErrorJson(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = (int) status;
            return ResponseEntity.status(statusCode).body(new Response(List.of(), HttpStatus.valueOf(statusCode).getReasonPhrase()));
        }
        return ResponseEntity.ok(new Response(List.of(), null));
    }

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH}, produces = MediaType.TEXT_HTML_VALUE)
    public String handleErrorHTML(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            final int statusCode = (int) status;
            return switch (statusCode) {
                case 404 -> PageContent.error404.get(new Random().nextInt(PageContent.error404.size()));
                case 500 -> PageContent.error500.get(new Random().nextInt(PageContent.error500.size()));
                default -> PageContent.errorAll.get(new Random().nextInt(PageContent.errorAll.size())).replace("$statusCode$", status.toString()).replace("$statusMessage$", HttpStatus.valueOf(statusCode).getReasonPhrase());
            };
        }
        return PageContent.errorAll.get(new Random().nextInt(PageContent.errorAll.size())).replace("$statusCode$", "500").replace("$statusMessage$", HttpStatus.valueOf(500).getReasonPhrase());
    }
}

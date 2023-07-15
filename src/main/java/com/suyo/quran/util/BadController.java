package com.suyo.quran.util;

import com.suyo.quran.models.Response;
import com.suyo.quran.models.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class BadController implements ErrorController {

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH}, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Response> handleErrorJson(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            return ResponseEntity.status(statusCode).body(new Response(new Status(statusCode), List.of(), null));
        }
        return ResponseEntity.ok(new Response(new Status(400, "error"), List.of(), null));
    }

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH}, produces = MediaType.TEXT_HTML_VALUE)
    public String handleErrorHTML(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return PageContent.error404.get(new Random().nextInt(PageContent.error404.size()));
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return PageContent.error500.get(new Random().nextInt(PageContent.error500.size()));
            } else {
                return PageContent.errorAll.get(new Random().nextInt(PageContent.errorAll.size())).replace("$statusCode$", status.toString()).replace("$statusMessage$", HttpStatus.valueOf(statusCode).getReasonPhrase());
            }
        }
        return PageContent.errorAll.get(new Random().nextInt(PageContent.errorAll.size())).replace("$statusCode$", "500").replace("$statusMessage$", HttpStatus.valueOf(500).getReasonPhrase());
    }
}

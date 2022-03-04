package com.example.bankmanagementservice.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class BankManagementExceptionHandler extends Throwable {
    private Object DataIntegrityViolationException= new DataIntegrityViolationException("");

    @ExceptionHandler( value = Exception.class)
    public @ResponseBody
    ResponseEntity<String> handleDataIntegraityException(
            final Exception myException,final  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        Class cause = myException.getClass();
        System.out.println(cause.toString());
        System.out.println(DataIntegrityViolationException.getClass());
        if(cause ==  DataIntegrityViolationException.getClass()) {
            body.put("timestamp", LocalDateTime.now());

            body.put("message", "............");
        }
        String content =
                "<header>"
                        + "<h1><span>Data integraity violvation </span>" +  body.get("timestamp") +"----" +body.get("message") + "</h1>"
                        + "</header>";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<String>(content, HttpStatus.BAD_REQUEST);
    }





}


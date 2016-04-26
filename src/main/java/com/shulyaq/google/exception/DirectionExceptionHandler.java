package com.shulyaq.google.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DirectionExceptionHandler {

    @ExceptionHandler(DirectionNotFoundException.class)
    public void handleException(HttpServletRequest req, Exception e) {
        System.out.println("Exception was intercepted: " + e.getMessage());
    }
}

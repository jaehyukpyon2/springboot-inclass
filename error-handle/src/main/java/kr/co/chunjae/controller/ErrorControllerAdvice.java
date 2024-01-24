package kr.co.chunjae.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeoutException;

@Slf4j
@ControllerAdvice
public class ErrorControllerAdvice {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(TimeoutException.class)
    public String handle(TimeoutException exception, HttpServletRequest request) {
        return "error/error";
    }
}

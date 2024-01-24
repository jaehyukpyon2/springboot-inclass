package kr.co.chunjae.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeoutException;

@Slf4j
@Controller
@RequestMapping(value = "/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    /*@ExceptionHandler(value = Exception.class)
    public String whtToDoException() throws  Exception {
        return "notfound";
    }

    @ExceptionHandler(value = {TimeoutException.class})
    public String notFoundException() throws Exception {
        return "timeoutException";
    }*/

    @GetMapping(value = "/check/exception")
    public String makeException() throws Exception {
        throw new Exception("Error!");
    }

    @GetMapping(value = "/check/time-out")
    public String timeoutException() throws Exception {
        throw new TimeoutException();
    }
}

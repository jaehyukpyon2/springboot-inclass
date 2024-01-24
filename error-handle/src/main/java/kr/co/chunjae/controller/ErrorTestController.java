package kr.co.chunjae.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
public class ErrorTestController {

    @GetMapping("/type-mismatch")
    public String t1 () throws HttpRequestMethodNotSupportedException {
        throw new HttpRequestMethodNotSupportedException(HttpMethod.POST.name());
    }

    @GetMapping("/no-handler")
    public String t2 () throws NoHandlerFoundException {
        throw new NoHandlerFoundException(HttpMethod.GET.name(), "/no-handler", null);
    }

    @GetMapping("/runtime")
    public String t3 () {
        throw new RuntimeException("error!");
    }

    @GetMapping("/hello")
    public String t4 () {
        throw new IllegalArgumentException();
    }
}

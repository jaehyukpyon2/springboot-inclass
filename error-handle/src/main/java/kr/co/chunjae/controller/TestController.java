package kr.co.chunjae.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TestController {
    @GetMapping(value = "/")
    public String home() {
        log.info("home");
        return "index";
    }
}

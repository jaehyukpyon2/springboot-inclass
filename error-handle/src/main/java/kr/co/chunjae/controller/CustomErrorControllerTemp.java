package kr.co.chunjae.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorControllerTemp implements ErrorController {

    @GetMapping(value = "/error")
    public String handleError() throws Exception {
        return "error/error";
    }
}

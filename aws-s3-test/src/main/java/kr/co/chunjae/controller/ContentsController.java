package kr.co.chunjae.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/contents")
public class ContentsController {

    @GetMapping(value = "/write")
    public String contentsWriteForm() {
        return "contents/write";
    }
}

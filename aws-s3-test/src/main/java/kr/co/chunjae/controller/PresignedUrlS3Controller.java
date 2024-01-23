package kr.co.chunjae.controller;

import kr.co.chunjae.service.PresignedUrlS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/presigned")
@Controller
public class PresignedUrlS3Controller {

    private final PresignedUrlS3Service presignedUrlS3Service;

    @PostMapping(value = "/generate-url")
    @ResponseBody
    public ResponseEntity<String> createPresignedUrl(@RequestParam String fileName) {
        final String path = "presigned";
        return ResponseEntity
                .ok()
                .body(presignedUrlS3Service.getPresignedUrl(path, fileName));
    }
}

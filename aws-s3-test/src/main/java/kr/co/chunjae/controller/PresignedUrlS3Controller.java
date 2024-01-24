package kr.co.chunjae.controller;

import kr.co.chunjae.dto.PresignedUrlWithFilenameDTO;
import kr.co.chunjae.service.PresignedUrlS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/presigned")
@Controller
public class PresignedUrlS3Controller {

    private final PresignedUrlS3Service presignedUrlS3Service;

    @PostMapping(value = "/generate-url")
    @ResponseBody
    public ResponseEntity<PresignedUrlWithFilenameDTO> createPresignedUrl(@RequestParam String fileName) {
        final String path = "contents-presigned";
        return ResponseEntity
                .ok()
                .body(presignedUrlS3Service.getPresignedUrl(path, fileName));
    }

    @GetMapping(value = "/view-url")
    @ResponseBody
    public ResponseEntity<String> getPresignedUrlForView(@RequestParam String fileName) throws UnsupportedEncodingException {
        fileName = URLDecoder.decode(fileName, "utf-8");
        String result = presignedUrlS3Service.generatePresignedUrlForView(fileName);
        return ResponseEntity
                .ok()
                .body(result);
    }
}

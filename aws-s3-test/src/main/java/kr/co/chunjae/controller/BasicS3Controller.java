package kr.co.chunjae.controller;

import kr.co.chunjae.service.BasicS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/basic-s3")
public class BasicS3Controller {

    private final BasicS3Service basicS3Service;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        final String path = "contents-basic/";
        return new ResponseEntity<>(basicS3Service.uploadFile(path, file), HttpStatus.CREATED);
    }

    @GetMapping(value = "/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam String fileName) throws UnsupportedEncodingException {
        fileName = URLDecoder.decode(fileName, "utf-8");
        log.info("fileName = {}", fileName);
        String onlyFileName = fileName.substring(fileName.indexOf("_".charAt(0)) + 1, fileName.length());
        log.info("onlyFileName = {}", onlyFileName);
        byte[] data = basicS3Service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-Type", "application/octet-stream")
                .header("Content-Disposition",
                       "attachment;filename=" +
                               new String(onlyFileName.getBytes("utf-8"), "ISO-8859-1"))
                .body(resource);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteFile(@RequestParam String fileName) throws UnsupportedEncodingException {
        fileName = URLDecoder.decode(fileName, "utf-8");
        return new ResponseEntity<>(basicS3Service.deleteFile(fileName), HttpStatus.NO_CONTENT);
    }
}

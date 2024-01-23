package kr.co.chunjae.controller;

import kr.co.chunjae.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.CREATED);
    }

    @GetMapping(value = "/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity.ok()
                .contentLength(data.length)
                .header("Content-Type", "application/octet-stream")
                .header("Content-Disposition", "attachment;filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping(value = "/delete/{fileName}")
    public ResponseEntity<String> deleteFile(String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.NO_CONTENT);
    }
}

package kr.co.chunjae.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BasicS3Service {

    @Value(value = "${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    public String uploadFile(String path, MultipartFile multipartFile) {
        String fileName = null;
        File convertedFile = convertMultipartFileToFile(multipartFile);
        if (convertedFile != null && convertedFile.exists()) {
            fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
            s3Client.putObject(new PutObjectRequest(bucketName, path + fileName, convertedFile));
            convertedFile.delete();
        }
        log.info("fileName = {}", fileName);
        return fileName;
    }

    public byte[] downloadFile(String fileName) {
        log.info("fileName = {}", fileName);
        S3Object object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            log.error("IOException!", e);
        }
        return null;
    }

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " => removed";
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) {
        File newFile = new File(multipartFile.getOriginalFilename());
        try {
            @Cleanup FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(multipartFile.getBytes());
        } catch (Exception e) {
            log.error("Exception!", e);
            return null;
        }
        return newFile;
    }
}

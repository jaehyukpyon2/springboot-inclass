package kr.co.chunjae.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.util.StringUtils;
import kr.co.chunjae.dto.PresignedUrlWithFilenameDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PresignedUrlS3Service {

    @Value(value = "${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    public PresignedUrlWithFilenameDTO getPresignedUrl(String path, String fileName) {
        String fileNameWithUUID = concatFileNameWithUUID(fileName);
        if (StringUtils.hasValue(path)) {
            fileNameWithUUID = path + "/" + fileNameWithUUID;
        }
        return PresignedUrlWithFilenameDTO.builder()
                .url(s3Client
                    .generatePresignedUrl(getGeneratePresignedUrlRequest(bucketName, fileNameWithUUID))
                    .toString())
                .fileName(fileNameWithUUID)
                .build();
    }

    private GeneratePresignedUrlRequest getGeneratePresignedUrlRequest(String bucketName, String fileName) {
        return new GeneratePresignedUrlRequest(bucketName, fileName)
                        .withMethod(HttpMethod.PUT)
                        .withExpiration(generatePresignedUrlExpirationTime());

        /*generatePresignedUrlRequest.addRequestParameter(Headers.S3_CANNED_ACL,
                CannedAccessControlList.PublicRead.toString());*/
    }

    private Date generatePresignedUrlExpirationTime() {
        Date expiration = new Date();

        long expTimeMillisec = expiration.getTime();
        expTimeMillisec += 1000 * 60 * 5; // 5 minutes
        expiration.setTime(expTimeMillisec);

        log.info(expiration.toString());
        return expiration;
    }

    private String concatFileNameWithUUID(String fileName){
        return UUID.randomUUID() + "_" + fileName;
    }

    public String generatePresignedUrlForView(String fileName) {
        Date date = new Date();
        long time = date.getTime();
        time += 1000 * 60 * 2; // 2 min
        date.setTime(time);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, fileName)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(date);

        String url = s3Client.generatePresignedUrl(generatePresignedUrlRequest).toString();
        return url;
    }
}

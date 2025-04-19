package com.moso.microservice.customerservice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moso.microservice.customerservice.enity.S3FileInfo;

import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class S3PreSignedURLController {

	
	private final S3Presigner presigner;
	private final String bucketName = "dealmgmt";
	private final S3Client s3Client;

	public S3PreSignedURLController() {
		this.presigner = S3Presigner.builder()
	                .region(Region.US_EAST_1) // change to your region
	                .credentialsProvider(ProfileCredentialsProvider.create()) // or use other providers use new InstanceProfileCredentialsProvider(false)
	                //.credentialsProvider(new InstanceProfileCredentialsProvider(false))
	                .build();
		
		this.s3Client = S3Client.builder()
	            .region(Region.US_EAST_1)
	            .credentialsProvider(ProfileCredentialsProvider.create())
	            .build();
	}
	
	

	@GetMapping("/presignedUrl")
	public URL generateGetPresignedUrl() {
	//public URL generatePresignedUrl(String objectKey, String contentType) {
		
		URL lurl = null;
		String objectKey="input/AWSCertifiedDataEngineerSlides.pdf";
		String contentType="application/pdf";
		GetObjectRequest objectRequest = GetObjectRequest.builder()
	                .bucket(bucketName)
	                .key(objectKey)
	                //.contentType(contentType)
	                .build();

	    PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest -> presignRequest
	                .signatureDuration(Duration.ofMinutes(10))
	                .getObjectRequest(objectRequest));

	    lurl = presignedRequest.url();
	    
	    presigner.close();
	    return lurl;
	 }
	
	//@CrossOrigin(origins = "*", allowedHeaders = "*")
	//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping("/presignedUrlPut/{file_name}")
	public Map<String, String> generatePresignedUrlUploadObjectKey(@PathVariable String file_name) {
		System.out.println("Entering with fileName = " + file_name);
		String lurl = null;
		String objectKey="input/" + file_name;
		//String localPath="src/main/resources/GA_StateOfTechTalent.pdf";
		PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest -> presignRequest
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(objectRequest));
        
        lurl = presignedRequest.url().toString();
        
        Map<String, String> response = new HashMap<>();
        response.put("url", lurl);
	            
	    presigner.close();
	    
	    System.out.println("Returning with URL = " + response);
	    
	    return response;
        
    }
	
	@GetMapping("/listfiles")
    public List<S3FileInfo> listFiles() {
        ListObjectsV2Request listRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

        ListObjectsV2Response listResponse = s3Client.listObjectsV2(listRequest);

        List<S3FileInfo> fileInfoList = new ArrayList<>();

        for (S3Object s3Object : listResponse.contents()) {
            String key = s3Object.key();

            // Presigned URL (GET)
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(10))
                    .getObjectRequest(getObjectRequest)
                    .build();

            PresignedGetObjectRequest presignedGetObjectRequest = presigner.presignGetObject(presignRequest);
            URL url = presignedGetObjectRequest.url();

            // HeadObject to get content-type
            HeadObjectRequest headRequest = HeadObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            HeadObjectResponse headResponse = s3Client.headObject(headRequest);

            fileInfoList.add(new S3FileInfo(
                    key,
                    url.toString(),
                    headResponse.contentType(),
                    s3Object.lastModified()
            ));
        }

        return fileInfoList;
    }
	
	
/*
	@GetMapping("/presignedUrlUpload")
	public URL generatePresignedUrlUploadObjectKey() {
        
		URL lurl = null;
		String objectKey="input/GA_StateOfTechTalent.pdf";
		String localPath="src/main/resources/GA_StateOfTechTalent.pdf";
		PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest -> presignRequest
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(objectRequest));
        
        lurl = presignedRequest.url();
	            
	    presigner.close();
	    try {
	    	uploadToS3UsingPresignedUrl(lurl, localPath);
	    }
	    catch(Exception e) {
	    	System.out.println(e.toString());
	    }
	    
	    return lurl;
        
    }
    */
	
	private void uploadToS3UsingPresignedUrl(URL presignedUrl, String localFilePath) throws Exception {
	    File file = ResourceUtils.getFile(localFilePath);
	    FileInputStream fis = new FileInputStream(file);

	    
	    HttpURLConnection connection = (HttpURLConnection) presignedUrl.openConnection();
	    connection.setDoOutput(true);
	    connection.setRequestMethod("PUT");
	    connection.setRequestProperty("Content-Length", String.valueOf(file.length()));
	    connection.setFixedLengthStreamingMode(file.length());

	    // Optional: set content-type if presigned URL expects it
	    // connection.setRequestProperty("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

	    try (var os = connection.getOutputStream()) {
	        fis.transferTo(os);
	    }

	    int responseCode = connection.getResponseCode();
	    if (responseCode == 200) {
	        System.out.println("Upload successful!");
	    } else {
	        System.out.println("Upload failed with response code: " + responseCode);
	    }
	}
	
}

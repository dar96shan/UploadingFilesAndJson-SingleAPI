package com.FileAndJson.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadMultipleFiles(
            @RequestParam("images")MultipartFile[] file
            ){
        this.logger.info("{} : number of files uploaded " ,file.length);
        Arrays.stream(file)
                .forEach(file1 -> {
                    logger.info("name of file : {}",file1.getOriginalFilename());
                    logger.info("File type : {}",file1.getContentType());
                    System.out.println("++++++++++++");
                });
        return ResponseEntity.ok("File uploaded");
    }
}

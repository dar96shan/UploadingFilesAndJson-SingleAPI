package com.FileAndJson.demo.Controller;

import com.FileAndJson.demo.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<?> addUserInformation(
            @RequestParam("file")MultipartFile file,
            @RequestParam("userData")String userData
            )  {

        this.logger.info("add user request");
        logger.info("File name : {}",file.getOriginalFilename());
      //  logger.info("User : {}",userData);

        User user= null;

        //converting String into Json
        try {
             user = mapper.readValue(userData, User.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
        }

        this.logger.info("User data is : {} ", user);
        return ResponseEntity.ok(user);
    }

}

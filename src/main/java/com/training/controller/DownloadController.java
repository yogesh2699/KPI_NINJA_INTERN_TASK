package com.training.controller;


import com.training.batch.PersonItemProcessor;
import com.training.validation.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/store")
public class DownloadController {

    @GetMapping
    public void downloadFile() throws IOException {
        // http request
        InputStream in = new URL("http://4339-59-96-152-132.ngrok.io/download/UserData.csv").openStream();
        Files.copy(in, Paths.get("C:\\Users\\welcome\\Documents\\Workplace\\SpringBatchDemo\\src\\main\\resources\\sample-data.csv"), StandardCopyOption.REPLACE_EXISTING);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, List<UserException>>> fetchAll() {
        HashMap<String, List<UserException>> list = PersonItemProcessor.hm;

        return new ResponseEntity<HashMap<String, List<UserException>>>(list, new HttpHeaders(),
                HttpStatus.OK);
    }

}

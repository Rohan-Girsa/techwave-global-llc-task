package com.techwave.techwavegloballlc.controller;

import com.techwave.techwavegloballlc.response.ResponseWrapper;
import com.techwave.techwavegloballlc.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<ResponseWrapper> getAllNews() {
        return new ResponseEntity<>(newsService.getAllNews(), HttpStatus.OK);
    }
}

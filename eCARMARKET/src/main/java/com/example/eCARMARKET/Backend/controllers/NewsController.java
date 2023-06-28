package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.news.News;
import com.example.eCARMARKET.Backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/tesla")
    public void getTeslaTest(){
        newsService.getTesla();
    }
}

package com.example.eCARMARKET.Backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VIewController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/profile")
    public String profile() { return "profile"; }

    @GetMapping("/stocks")
    public String stocks() { return "stocks"; }

    @GetMapping("/markets")
    public String markets() { return "markets"; }

    @GetMapping("/global-data")
    public String globalData() { return "global-data"; }

    @GetMapping("/news")
    public String news() { return "news"; }

    @GetMapping("/your-feed")
    public String yourFeed() { return "your-feed"; }

}

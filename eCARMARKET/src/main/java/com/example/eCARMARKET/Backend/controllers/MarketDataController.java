package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.services.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastic")
public class MarketDataController {

    @Autowired
    private MarketDataService marketDataService;

    @GetMapping("/findAll")
    Iterable<MarketData> findAll(){
        return marketDataService.getMarkets();
    }

}

package com.example.eCARMARKET.Backend.controllers.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.services.marketdata.MarketDataElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastic")
public class MarketDataElasticController {

    @Autowired
    private MarketDataElasticService marketDataElasticService;

    @GetMapping("/findAll")
    Iterable<MarketData> findAll(){
        return marketDataElasticService.getMarkets();
    }

}

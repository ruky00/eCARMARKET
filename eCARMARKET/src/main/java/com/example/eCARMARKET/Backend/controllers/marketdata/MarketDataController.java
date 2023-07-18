package com.example.eCARMARKET.Backend.controllers.marketdata;

import com.example.eCARMARKET.Backend.services.marketdata.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class MarketDataController {

    @Autowired
    private MarketDataService marketDataService;

}

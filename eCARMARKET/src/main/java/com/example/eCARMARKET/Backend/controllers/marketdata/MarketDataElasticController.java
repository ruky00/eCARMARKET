package com.example.eCARMARKET.Backend.controllers.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.repositories.marketdata.MarketDataMongoDBRepository;
import com.example.eCARMARKET.Backend.services.marketdata.MarketDataElasticService;
import org.elasticsearch.client.license.LicensesStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marketdata")
public class MarketDataElasticController {

    @Autowired
    private MarketDataMongoDBRepository marketDataMongoDBRepository;


}

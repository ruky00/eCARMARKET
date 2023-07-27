package com.example.eCARMARKET.Backend.services.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.repositories.marketdata.MarketDataMongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketDataElasticService {

    @Autowired
    private MarketDataMongoDBRepository marketDataMongoDBRepository;

    public Iterable<MarketData> getMarkets(){
        return marketDataMongoDBRepository.findAll();
    }

}

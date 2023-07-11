package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.repositories.MarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {

    @Autowired
    private MarketDataRepository marketDataRepository;

    public Iterable<MarketData> getMarkets(){
        return marketDataRepository.findAll();
    }

}

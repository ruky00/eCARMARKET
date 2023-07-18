package com.example.eCARMARKET.Backend.services.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import com.example.eCARMARKET.Backend.repositories.marketdata.MarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketDataService {

    @Autowired
    private MarketDataRepository marketDataRepository;

    public Optional<MarketData> findMarketDataById(Long id){
        return marketDataRepository.findMarketDataById(id);
    }

}

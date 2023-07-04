package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.Market;
import com.example.eCARMARKET.Backend.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public Optional<Market> findByCountryName(String id) {
        return marketRepository.findById(id);
    }

}

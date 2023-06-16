package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

}

package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.stocks.Stock;
import com.example.eCARMARKET.Backend.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void save(Stock stock){
        stockRepository.save(stock);
    }

    public Optional<Stock> findById(Long id){
        return stockRepository.findById(id);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }


}

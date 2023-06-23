package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.MetaData;
import com.example.eCARMARKET.Backend.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findById(Long id);

}

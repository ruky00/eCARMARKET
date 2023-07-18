package com.example.eCARMARKET.Backend.repositories.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketDataRepository extends JpaRepository<MarketData, Long> {

    Optional<MarketData> findMarketDataById(Long id);

}

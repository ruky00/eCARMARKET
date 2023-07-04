package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.Market;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {

    Optional<Market> findById(String id);
    @NotNull
    List<Market> findAllMarkets();

}

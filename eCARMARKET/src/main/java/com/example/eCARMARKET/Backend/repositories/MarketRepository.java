package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {

    Optional<Market> findById(String id);

}

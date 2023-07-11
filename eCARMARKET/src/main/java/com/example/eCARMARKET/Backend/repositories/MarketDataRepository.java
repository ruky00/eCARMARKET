package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.MarketData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MarketDataRepository extends ElasticsearchRepository<MarketData, String> { }

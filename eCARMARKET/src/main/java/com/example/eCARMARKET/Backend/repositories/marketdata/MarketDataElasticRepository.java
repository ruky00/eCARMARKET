package com.example.eCARMARKET.Backend.repositories.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataElasticRepository extends ElasticsearchRepository<MarketData, String> { }

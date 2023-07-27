package com.example.eCARMARKET.Backend.repositories.marketdata;

import com.example.eCARMARKET.Backend.models.MarketData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface MarketDataMongoDBRepository extends MongoRepository<MarketData, String> { }

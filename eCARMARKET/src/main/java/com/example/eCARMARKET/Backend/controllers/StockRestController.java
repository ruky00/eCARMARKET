package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.Stock;
import com.example.eCARMARKET.Backend.services.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class StockRestController {

    @Autowired
    private StockService stockService;

    private final OkHttpClient client = new OkHttpClient();


    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/monthly")
    public ResponseEntity<Object> getStock(@RequestParam(value = "symbol") String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="+symbol+"&apikey=97OQGDE121GB24RO";


        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Stock stock = objectMapper.readValue(jsonResponse, Stock.class);
        System.out.println(stock.toString());
        stockService.save(stock);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }


}

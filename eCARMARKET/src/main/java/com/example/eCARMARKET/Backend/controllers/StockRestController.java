package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.stocks.Stock;
import com.example.eCARMARKET.Backend.services.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080", methods = RequestMethod.GET)
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
        Stock stock = objectMapper.readValue(jsonResponse, Stock.class);
        stockService.save(stock);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }
    @GetMapping("/demo")
    public ResponseEntity<Object> getStockDemo(@RequestParam(value = "symbol") String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="+symbol+"&apikey=demo";
        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(jsonResponse, Stock.class);
        stockService.save(stock);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }
}

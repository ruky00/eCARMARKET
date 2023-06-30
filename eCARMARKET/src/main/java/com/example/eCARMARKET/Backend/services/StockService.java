package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.stocks.Stock;
import com.example.eCARMARKET.Backend.repositories.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    private StockService stockService;

    private final OkHttpClient client = new OkHttpClient();

    public void save(Stock stock){
        stockRepository.save(stock);
    }

    public Optional<Stock> findById(Long id){
        return stockRepository.findById(id);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    public ResponseEntity<Object> getStockMonthly(@RequestParam(value = "symbol") String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="+symbol+"&apikey=97OQGDE121GB24RO";
        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(jsonResponse, Stock.class);
        stockService.save(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    public ResponseEntity<Object> getStockWeekly(@RequestParam(value = "symbol") String symbol) throws IOException {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="+symbol+"&apikey=97OQGDE121GB24RO";
        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(jsonResponse, Stock.class);
        stockService.save(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

}



package com.example.eCARMARKET.Backend.models;

import com.example.eCARMARKET.Backend.models.stocks.Stock;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clientEmail;

    @OneToMany
    private List<Stock> stocks;

    @OneToMany
    private List<MarketData> marketData;

    @OneToMany
    private List<GlobalDataSection> globalDataSections;

    private String newsTopics;

    public String getClientEmail(){ return clientEmail; }

    public void setClientEmail(String clientEmail){ this.clientEmail = clientEmail; }

    public List<Stock> getStocks(){ return stocks; }

    public void setStocks(List<Stock> stocks){ this.stocks = stocks; }



    public List<MarketData> getMarkets(){ return marketData; }

    public void setMarkets(List<MarketData> marketData){ this.marketData = marketData; }

    public List<GlobalDataSection> getGlobalInformation(){ return globalDataSections; }

    public void setGlobalInformation(List<GlobalDataSection> globalInformation){ this.globalDataSections = globalInformation; }

    public String getNewsTopics(){ return newsTopics; }

    public void setNewsTopics(String newsTopics){ this.newsTopics = newsTopics; }

    public void removeNewsTopic(String newsTopicToRemove){ this.newsTopics.replace(newsTopicToRemove, ""); }

    public Profile(String clientEmail){
        this.clientEmail = clientEmail;
    }

}

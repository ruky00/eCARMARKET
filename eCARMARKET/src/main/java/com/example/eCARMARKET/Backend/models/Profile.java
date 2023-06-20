package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clientEmail;

    private List<String> stocks;

    private List<Market> markets;

    private List<GlobalDataSection> globalDataSections;

    private List<String> newsTopics;

    public String getClientEmail(){ return clientEmail; }

    public void setClientEmail(String clientEmail){ this.clientEmail = clientEmail; }

    public List<String> getStocks(){ return stocks; }

    public void setStocks(List<String> stocks){ this.stocks = stocks; }

    public void addStock(String newStock) { this.stocks.add(newStock); }

    public void removeStock(String stockToRemove){ this.stocks.remove(stockToRemove); }

    public List<Market> getMarkets(){ return markets; }

    public void setMarkets(List<Market> markets){ this.markets = markets; }

    public void addMarket(Market newMarket) { this.markets.add(newMarket); }

    public void removeMarket(Market marketToRemove){ this.markets.remove(marketToRemove); }

    public List<GlobalDataSection> getGlobalInformation(){ return globalDataSections; }

    public void setGlobalInformation(List<GlobalDataSection> globalInformation){ this.globalDataSections = globalInformation; }

    public void addGlobalInformation(GlobalDataSection newGlobalInformation) { this.globalDataSections.add(newGlobalInformation); }

    public void removeGlobalInformation(GlobalDataSection globalInformationToRemove){ this.globalDataSections.remove(globalInformationToRemove); }

    public List<String> getNewsTopics(){ return newsTopics; }

    public void setNewsTopics(List<String> newsTopics){ this.newsTopics = newsTopics; }

    public void addNewsTopic(String newNewsTopic) { this.newsTopics.add(newNewsTopic); }

    public void removeNewsTopic(String newsTopicToRemove){ this.newsTopics.remove(newsTopicToRemove); }

    public Profile(String clientEmail){
        this.clientEmail = clientEmail;
        this.stocks = new ArrayList<String>();
        this.markets = new ArrayList<Market>();
        this.globalDataSections = new ArrayList<GlobalDataSection>();
        this.newsTopics = new ArrayList<String>();
    }

    public Profile(String clientEmail, List<String> stocks, List<Market> markets,
                   List<GlobalDataSection> globalDataSections, List<String> newsTopics){
        this.clientEmail = clientEmail;
        this.stocks = stocks;
        this.markets = markets;
        this.globalDataSections = globalDataSections;
        this.newsTopics = newsTopics;
    }

}

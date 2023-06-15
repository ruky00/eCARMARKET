package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {
    @Id
    private Client client;

    private List<Stock> stocks;

    private List<Market> markets;

    private List<GlobalDataSection> globalDataSections;

    private List<String> newsTopics;

    public Client getClient(){ return client; }

    public void setClient(Client client){ this.client = client; }

    public List<Stock> getStocks(){ return stocks; }

    public void setStocks(List<Stock> stocks){ this.stocks = stocks; }

    public void addStock(Stock newStock) { this.stocks.add(newStock); }

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

    public Profile(Client client){
        this.client = client;
        this.stocks = new ArrayList<Stock>();
        this.markets = new ArrayList<Market>();
        this.globalDataSections = new ArrayList<GlobalDataSection>();
        this.newsTopics = new ArrayList<String>();
    }

    public Profile(Client client, List<Stock> stocks, List<Market> markets,
                   List<GlobalDataSection> globalDataSections, List<String> newsTopics){
        this.client = client;
        this.stocks = stocks;
        this.markets = markets;
        this.globalDataSections = globalDataSections;
        this.newsTopics = newsTopics;
    }

}

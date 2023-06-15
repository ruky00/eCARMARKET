package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {
    @Id
    private Client client;

    private List<Stock> stocks;

    private List<String> markets;

    private List<String> globalInformation;

    private List<String> newsTopics;

    public Client getClient(){ return client; }

    public void setClient(Client client){ this.client = client; }

    public List<Stock> getStocks(){ return stocks; }

    public void setStocks(List<Stock> stocks){ this.stocks = stocks; }

    public void addStock(Stock newStock) { this.stocks.add(newStock); }

    public void removeStock(String stockToRemove){ this.stocks.remove(stockToRemove); }

    public List<String> getMarkets(){ return markets; }

    public void setMarkets(List<String> markets){ this.markets = markets; }

    public void addMarket(String newMarket) { this.markets.add(newMarket); }

    public void removeMarket(String marketToRemove){ this.markets.remove(marketToRemove); }

    public List<String> getGlobalInformation(){ return globalInformation; }

    public void setGlobalInformation(List<String> globalInformation){ this.globalInformation = globalInformation; }

    public void addGlobalInformation(String newGlobalInformation) { this.globalInformation.add(newGlobalInformation); }

    public void removeGlobalInformation(String globalInformationToRemove){ this.globalInformation.remove(globalInformationToRemove); }

    public List<String> getNewsTopics(){ return newsTopics; }

    public void setNewsTopics(List<String> newsTopics){ this.newsTopics = newsTopics; }

    public void addNewsTopic(String newNewsTopic) { this.newsTopics.add(newNewsTopic); }

    public void removeNewsTopic(String newsTopicToRemove){ this.newsTopics.remove(newsTopicToRemove); }

    public String getClientName(){ return client.getName(); }

    public String getClientSurname(){ return client.getSurname(); }

    public String getClientEmail(){ return client.getEmail(); }

    public String getClientOccupation(){ return client.getOccupation(); }

    public Blob getClientImage(){ return client.getImageFile(); }

    public Profile(Client client){
        this.client = client;
        this.stocks = new ArrayList<Stock>();
        this.markets = new ArrayList<String>();
        this.globalInformation = new ArrayList<String>();
        this.newsTopics = new ArrayList<String>();
    }

    public Profile(Client client, List<Stock> stocks, List<String> markets,
                   List<String> globalInformation, List<String> newsTopics){
        this.client = client;
        this.stocks = stocks;
        this.markets = markets;
        this.globalInformation = globalInformation;
        this.newsTopics = newsTopics;
    }

}

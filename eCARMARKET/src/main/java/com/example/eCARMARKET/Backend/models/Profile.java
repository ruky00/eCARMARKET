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

    private String stocks;

    private String markets;

    private String globalDataSections;

    private String newsTopics;

    public String getClientEmail(){ return clientEmail; }

    public void setClientEmail(String clientEmail){ this.clientEmail = clientEmail; }

    public String getStocks(){ return stocks; }

    public void setStocks(String stocks){ this.stocks = stocks; }

    public void addStock(String newStock) { this.stocks += "_" + newStock; }

    public void removeStock(String stockToRemove){ this.stocks.replace(stockToRemove, ""); }

    public String getMarkets(){ return markets; }

    public void setMarkets(String markets){ this.markets = markets; }

    public void addMarket(String newMarket) { this.markets += "_" + newMarket; }

    public void removeMarket(String marketToRemove){ this.markets.replace(marketToRemove, ""); }

    public String getGlobalInformation(){ return globalDataSections; }

    public void setGlobalInformation(String globalInformation){ this.globalDataSections = globalInformation; }

    public void addGlobalInformation(String newGlobalInformation) { this.globalDataSections += "_" + newGlobalInformation; }

    public void removeGlobalInformation(String globalInformationToRemove){ this.globalDataSections.replace(globalInformationToRemove, ""); }

    public String getNewsTopics(){ return newsTopics; }

    public void setNewsTopics(String newsTopics){ this.newsTopics = newsTopics; }

    public void addNewsTopic(String newNewsTopic) { this.newsTopics += "_" + newNewsTopic; }

    public void removeNewsTopic(String newsTopicToRemove){ this.newsTopics.replace(newsTopicToRemove, ""); }

    public Profile(String clientEmail){
        this.clientEmail = clientEmail;
    }

}

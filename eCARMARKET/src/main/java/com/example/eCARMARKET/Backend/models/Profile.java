package com.example.eCARMARKET.Backend.models;

import com.example.eCARMARKET.Backend.models.stocks.Stock;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clientEmail;

    @OneToMany(mappedBy = "cart")
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "cart")
    private Set<Market> markets;

    @OneToMany(mappedBy = "cart")
    private Set<GlobalDataSection> globalDataSections;

    private String newsTopics;

    public String getClientEmail(){ return clientEmail; }

    public void setClientEmail(String clientEmail){ this.clientEmail = clientEmail; }

    public Set<Stock> getStocks(){ return stocks; }

    public void setStocks(Set<Stock> stocks){ this.stocks = stocks; }

    public void addStock(Stock newStock) { this.stocks.add(newStock); }

    public void removeStock(Stock stockToRemove){ this.stocks.remove(stockToRemove); }

    public Set<Market> getMarkets(){ return markets; }

    public void setMarkets(Set<Market> markets){ this.markets = markets; }

    public void addMarket(Market newMarket) { this.markets.add(newMarket); }

    public void removeMarket(Market marketToRemove){ this.markets.remove(marketToRemove); }

    public Set<GlobalDataSection> getGlobalInformation(){ return globalDataSections; }

    public void setGlobalInformation(Set<GlobalDataSection> globalInformation){ this.globalDataSections = globalInformation; }

    public void addGlobalInformation(GlobalDataSection newGlobalInformation) { this.globalDataSections.add(newGlobalInformation); }

    public void removeGlobalInformation(GlobalDataSection globalInformationToRemove){ this.globalDataSections.remove(globalInformationToRemove); }

    public String getNewsTopics(){ return newsTopics; }

    public void setNewsTopics(String newsTopics){ this.newsTopics = newsTopics; }

    public void addNewsTopic(String newNewsTopic) { this.newsTopics += "_" + newNewsTopic; }

    public void removeNewsTopic(String newsTopicToRemove){ this.newsTopics.replace(newsTopicToRemove, ""); }

    public Profile(String clientEmail){
        this.clientEmail = clientEmail;
    }

}

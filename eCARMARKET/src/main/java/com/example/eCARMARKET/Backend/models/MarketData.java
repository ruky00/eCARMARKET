package com.example.eCARMARKET.Backend.models;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Document(indexName = "markets")
public class MarketData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String region;

    private String category;

    private String marketDataParameter;

    private String mode;

    private String powerTrain;

    private int marketDataYear;

    private String unit;

    private double marketDataValue;

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getParameter() { return marketDataParameter; }

    public void setParameter(String parameter) { this.marketDataParameter = parameter; }

    public String getMode() { return mode; }

    public void setMode(String mode) { this.mode = mode; }

    public String getPowerTrain() { return powerTrain; }

    public void setPowerTrain(String powerTrain) { this.powerTrain = powerTrain; }

    public int getYear() { return marketDataYear; }

    public void setYear(int year) { this.marketDataYear = year; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public double getValue() { return marketDataValue; }

    public void setValue(double value) { this.marketDataValue = value; }

    public MarketData(String region, String category, String marketDataParameter, String mode, String powerTrain,
                      int marketDataYear, String unit, double marketDataValue) {
        this.region = region;
        this.category = category;
        this.marketDataParameter = marketDataParameter;
        this.mode = mode;
        this.powerTrain = powerTrain;
        this.marketDataYear = marketDataYear;
        this.unit = unit;
        this.marketDataValue = marketDataValue;
    }
}

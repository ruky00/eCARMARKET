package com.example.eCARMARKET.Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection
    @JsonProperty("Monthly Time Series")
    private Map<Date, MonthlyTimeSeries> monthlyTimeSeries;

    @JsonProperty("Meta Data")
    private MetaData metaData;

    public Map<Date, MonthlyTimeSeries> getMonthlyTimeSeries() {
        return monthlyTimeSeries;
    }

    public void setMonthlyTimeSeries(Map<Date, MonthlyTimeSeries> monthlyTimeSeries) {
        this.monthlyTimeSeries = monthlyTimeSeries;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Stock(){}

    public Stock(Map<Date, MonthlyTimeSeries> stockValues, MetaData metaData) {
        this.monthlyTimeSeries=stockValues;
        this.metaData = metaData;
    }
}

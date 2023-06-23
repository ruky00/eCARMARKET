package com.example.eCARMARKET.Backend.models.stocks;

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

    @ElementCollection
    @JsonProperty ("Time Series (Daily)")
    private Map<Date, MonthlyTimeSeries> dailyTimeSeries;
    @ElementCollection
    @JsonProperty("Weekly Time Series")
    private Map<Date, MonthlyTimeSeries> weeklyTimeSeries;

    @JsonProperty("Meta Data")
    private MetaData metaData;


    public Map<Date, MonthlyTimeSeries> getDailyTimeSeries() {
        return dailyTimeSeries;
    }

    public void setDailyTimeSeries(Map<Date, MonthlyTimeSeries> dailyTimeSeries) {
        this.dailyTimeSeries = dailyTimeSeries;
    }

    public Map<Date, MonthlyTimeSeries> getWeeklyTimeSeries() {
        return weeklyTimeSeries;
    }

    public void setWeeklyTimeSeries(Map<Date, MonthlyTimeSeries> weeklyTimeSeries) {
        this.weeklyTimeSeries = weeklyTimeSeries;
    }

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
        String time = metaData.getInformation().toLowerCase();
        if(time.contains("daily")){
            this.dailyTimeSeries= stockValues;
        }else if (time.contains("monthly")){
            this.monthlyTimeSeries=stockValues;
        }else
            this.weeklyTimeSeries=stockValues;
        this.metaData = metaData;
    }


}

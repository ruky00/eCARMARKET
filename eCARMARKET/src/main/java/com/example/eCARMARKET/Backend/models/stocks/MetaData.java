package com.example.eCARMARKET.Backend.models.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {
    @JsonProperty("1. Information")
    private String Information;
    @JsonProperty("2. Symbol")
    private String symbol;
    @JsonProperty("3. Last Refreshed")
    private Date lastRefreshed;
    @JsonProperty("4. Time Zone")
    private String timeZone;

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        this.Information = information;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(Date lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public MetaData(){}
    public MetaData(String information, String symbol, Date lastRefreshed, String timeZone){
        this.Information=information;
        this.symbol=symbol;
        this.lastRefreshed=lastRefreshed;
        this.timeZone=timeZone;
    }

}

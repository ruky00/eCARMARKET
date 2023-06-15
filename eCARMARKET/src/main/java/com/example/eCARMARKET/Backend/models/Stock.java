package com.example.eCARMARKET.Backend.models;

import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Stock {

    @Id
    private String id;

    private String commercialName;

    private double previousClose;

    private double open;

    private String bid;

    private String ask;

    private String daysRange;

    private String fiftyTwoWeeksRange;

    private int volume;

    private int averageVolume;

    private String marketCapitalization;

    private double beta5YMonthly;

    private double peRatio;

    private double eps;

    private String earningsDate;

    private String forwardAndDividendYield;

    private String exDividendDate;

    private double oneYTargetEst;

    private List<HistoricalData> historicalData;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getCommercialName() { return commercialName; }

    public void setCommercialName(String commercialName) { this.commercialName = commercialName; }

    public double getPreviousClose() { return previousClose; }

    public void setPreviousClose(double previousClose) { this.previousClose = previousClose; }

    public double getOpen() { return open; }

    public void setOpen(double open) { this.open = open; }

    public String getBid() { return bid; }

    public void setBid(String bid) { this.bid = bid; }

    public String getAsk() { return ask; }

    public void setAsk(String ask) { this.ask = ask; }

    public String getDaysRange() { return daysRange; }

    public void setDaysRange(String daysRange) { this.daysRange = daysRange; }

    public String getFiftyTwoWeeksRange() { return fiftyTwoWeeksRange; }

    public void setFiftyTwoWeeksRange(String fiftyTwoWeeksRange) { this.fiftyTwoWeeksRange = fiftyTwoWeeksRange; }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    public int getAverageVolume() { return averageVolume; }

    public void setAverageVolume(int averageVolume) { this.averageVolume = averageVolume; }

    public String getMarketCapitalization() { return marketCapitalization; }

    public void setMarketCapitalization(String marketCapitalization) { this.marketCapitalization = marketCapitalization; }

    public double getBeta5YMonthly() { return beta5YMonthly; }

    public void setBeta5YMonthly(double beta5YMonthly) { this.beta5YMonthly = beta5YMonthly; }

    public double getPeRatio() { return peRatio; }

    public void setPeRatio(double peRatio) { this.peRatio = peRatio; }

    public double getEps() { return eps; }

    public void setEps(double eps) { this.eps = eps; }

    public String getEarningsDate() { return earningsDate; }

    public void setEarningsDate(String earningsDate) { this.earningsDate = earningsDate; }

    public String getForwardAndDividendYield() { return forwardAndDividendYield; }

    public void setForwardAndDividendYield(String forwardAndDividendYield) { this.forwardAndDividendYield = forwardAndDividendYield; }

    public String getExDividendDate() { return exDividendDate; }

    public void setExDividendDate(String exDividendDate) { this.exDividendDate = exDividendDate; }

    public double getOneYTargetEst() { return oneYTargetEst; }

    public void setOneYTargetEst(double oneYTargetEst) { this.oneYTargetEst = oneYTargetEst; }

    public List<HistoricalData> getHistoricalData() { return historicalData; }

    public void setHistoricalData(List<HistoricalData> historicalData) { this.historicalData = historicalData; }

    public Stock(String id, String commercialName, double previousClose, double open,
                 String bid, String ask, String daysRange, String fiftyTwoWeeksRange,
                 int volume, int averageVolume, String marketCapitalization,
                 double beta5YMonthly, double peRatio, double eps, String earningsDate,
                 String forwardAndDividendYield, String exDividendDate, double oneYTargetEst,
                 List<HistoricalData> historicalData) {
        this.id = id;
        this.commercialName = commercialName;
        this.previousClose = previousClose;
        this.open = open;
        this.bid = bid;
        this.ask = ask;
        this.daysRange = daysRange;
        this.fiftyTwoWeeksRange = fiftyTwoWeeksRange;
        this.volume = volume;
        this.averageVolume = averageVolume;
        this.marketCapitalization = marketCapitalization;
        this.beta5YMonthly = beta5YMonthly;
        this.peRatio = peRatio;
        this.eps = eps;
        this.earningsDate = earningsDate;
        this.forwardAndDividendYield = forwardAndDividendYield;
        this.exDividendDate = exDividendDate;
        this.oneYTargetEst = oneYTargetEst;
        this.historicalData = historicalData;
    }
}

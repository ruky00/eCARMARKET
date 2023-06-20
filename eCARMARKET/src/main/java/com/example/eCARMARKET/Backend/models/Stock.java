package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Stock {

    @Id
    private String id;

    private Date date;

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

    /**
     * Returns the id, which is the specific acronym for the company in
     * the stock market
     * @return String that contains the id of the company
     */
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    /**
     * Returns the date of the stock data
     * @return Date class object that contains
     * the date of the stock data
     */
    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    /**
     * Returns the commercial name of the company
     * @return String that contains the commercial name of the company
     */
    public String getCommercialName() { return commercialName; }

    public void setCommercialName(String commercialName) { this.commercialName = commercialName; }

    /**
     * Returns the security's closing price on the preceding
     * time period of the one being referenced
     * @return double that contains the security's closing
     * price on the preceding time period of the one being
     * referenced
     */
    public double getPreviousClose() { return previousClose; }

    public void setPreviousClose(double previousClose) { this.previousClose = previousClose; }

    /**
     * Return's the security's first price in the current
     * time period being referenced
     * @return double that contains the security's first
     * price in the time period being referenced
     */
    public double getOpen() { return open; }

    public void setOpen(double open) { this.open = open; }

    /**
     * Returns the highest price a buyer will pay to buy a
     * specified number of shares of a stock at any given time
     * @return String that contains the highest price a buyer
     * will pay to buy a specified number of shares of a stock
     * at anu given time
     */
    public String getBid() { return bid; }

    public void setBid(String bid) { this.bid = bid; }

    /**
     * Returns the lowest price at which a seller will sell a
     * specified number of stocks
     * @return String that contains the lowest price at which
     * a seller will sell a specified number of stocks
     */
    public String getAsk() { return ask; }

    public void setAsk(String ask) { this.ask = ask; }

    /**
     * Highest and lowest price of the security for the
     * current day
     * @return String that contains the highest and the lowest
     * price of the security for the current day
     */
    public String getDaysRange() { return daysRange; }

    public void setDaysRange(String daysRange) { this.daysRange = daysRange; }

    /**
     * Highest and lowest price of the security for the
     * last 52 weeks
     * @return String that contains the highest and the
     * lowest price of the security for the last 52 weeks
     */
    public String getFiftyTwoWeeksRange() { return fiftyTwoWeeksRange; }

    public void setFiftyTwoWeeksRange(String fiftyTwoWeeksRange) { this.fiftyTwoWeeksRange = fiftyTwoWeeksRange; }

    /**
     * Returns the number of shares of the company
     * that have been traded over the current day
     * @return int that contains the number of shares
     * of the company that have been traded over the
     * current day
     */
    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    /**
     * Returns the average number of shares of the
     * company traded each day
     * @return int that contains the average number
     * of shares of the company traded each day
     */
    public int getAverageVolume() { return averageVolume; }

    public void setAverageVolume(int averageVolume) { this.averageVolume = averageVolume; }

    /**
     * Returns the market capitalization of the company
     * @return String that contains the market capitalization
     * of the company
     */
    public String getMarketCapitalization() { return marketCapitalization; }

    public void setMarketCapitalization(String marketCapitalization) { this.marketCapitalization = marketCapitalization; }

    /**
     * Returns the volatility of the stock. It measures how much
     * movement the stock has gone through in its recent history
     * (in this case, a month)
     * @return double that contains the volatility of the stock
     */
    public double getBeta5YMonthly() { return beta5YMonthly; }

    public void setBeta5YMonthly(double beta5YMonthly) { this.beta5YMonthly = beta5YMonthly; }

    /**
     * Returns the Price to Earnings ratio. It is
     * calculated by dividing the earnings by the
     * stock's share price
     * @return double that contains the Price to
     * Earnings ratio
     */
    public double getPeRatio() { return peRatio; }

    public void setPeRatio(double peRatio) { this.peRatio = peRatio; }

    /**
     * Returns the EPS ratio. It is similar to
     * the EP ratio but it allows the investor
     * to compare to each individual share
     * @return double that contains the EPS
     * ratio
     */
    public double getEps() { return eps; }

    public void setEps(double eps) { this.eps = eps; }

    /**
     * Returns the release date of the company's earnings
     * @return String that contains the release date of
     * the company's earnings
     */
    public String getEarningsDate() { return earningsDate; }

    public void setEarningsDate(String earningsDate) { this.earningsDate = earningsDate; }

    /**
     * Returns the number of dividends to be received
     * per share purchased
     * @return String that contains the number of
     * dividends to be received per share purchased
     */
    public String getForwardAndDividendYield() { return forwardAndDividendYield; }

    public void setForwardAndDividendYield(String forwardAndDividendYield) { this.forwardAndDividendYield = forwardAndDividendYield; }

    /**
     * Returns the date prior to which the investor
     * must own a share in order to receive dividends
     * from it
     * @return String that contains the date prior
     * to which the investor must own a share in order
     * to receive dividends from it
     */
    public String getExDividendDate() { return exDividendDate; }

    public void setExDividendDate(String exDividendDate) { this.exDividendDate = exDividendDate; }

    /**
     * Returns the price analysts predict the
     * stock will be one year from now
     * @return double that contains the price
     * analysts predict the stock will be one
     * year from now
     */
    public double getOneYTargetEst() { return oneYTargetEst; }

    public void setOneYTargetEst(double oneYTargetEst) { this.oneYTargetEst = oneYTargetEst; }

    public Stock(String id, Date date, String commercialName, double previousClose, double open,
                 String bid, String ask, String daysRange, String fiftyTwoWeeksRange,
                 int volume, int averageVolume, String marketCapitalization,
                 double beta5YMonthly, double peRatio, double eps, String earningsDate,
                 String forwardAndDividendYield, String exDividendDate, double oneYTargetEst) {
        this.id = id;
        this.date = date;
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
    }
}

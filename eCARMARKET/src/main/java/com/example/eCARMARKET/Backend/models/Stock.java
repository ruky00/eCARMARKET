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

    private String daysRange;

    private int volume;

    private int averageVolume;

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
     * Highest and lowest price of the security for the
     * current day
     * @return String that contains the highest and the lowest
     * price of the security for the current day
     */
    public String getDaysRange() { return daysRange; }

    public void setDaysRange(String daysRange) { this.daysRange = daysRange; }

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

    public Stock(String id, Date date, String commercialName, double previousClose, double open,
                 String bid, String daysRange, int volume, int averageVolume) {
        this.id = id;
        this.date = date;
        this.commercialName = commercialName;
        this.previousClose = previousClose;
        this.open = open;
        this.bid = bid;
        this.daysRange = daysRange;
        this.volume = volume;
        this.averageVolume = averageVolume;
    }
}

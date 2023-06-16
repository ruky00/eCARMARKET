package com.example.eCARMARKET.Backend.models.aux;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
public class HistoricalData {

    private long id;

    private Date date;

    private double open;

    private double high;

    private double low;

    private double close;

    private double adjClose;

    private int volume;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public double getOpen() { return open; }

    public void setOpen(double open) { this.open = open; }

    public double getHigh() { return high; }

    public void setHigh(double high) { this.high = high; }

    public double getLow() { return low; }

    public void setLow(double low) { this.low = low; }

    public double getClose() { return close; }

    public void setClose(double close) { this.close = close; }

    public double getAdjClose() { return adjClose; }

    public void setAdjClose(double adjClose) { this.adjClose = adjClose; }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    public HistoricalData(long id, Date date, double open, double high, double low,
                          double close, double adjClose, int volume) {
        this.id = id;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
    }
}

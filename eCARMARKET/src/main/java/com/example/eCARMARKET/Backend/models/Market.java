package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Market {
    @Id
    private String _id;

    private String region;

    private String category;

    private String parameter;

    private String mode;

    private String powerTrain;

    private int year;

    private String unit;

    private double value;

    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getParameter() { return parameter; }

    public void setParameter(String parameter) { this.parameter = parameter; }

    public String getMode() { return mode; }

    public void setMode(String mode) { this.mode = mode; }

    public String getPowerTrain() { return powerTrain; }

    public void setPowerTrain(String powerTrain) { this.powerTrain = powerTrain; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }

    public Market(String _id, String region, String category, String parameter, String mode, String powerTrain,
                  int year, String unit, double value) {
        this._id = _id;
        this.region = region;
        this.category = category;
        this.parameter = parameter;
        this.mode = mode;
        this.powerTrain = powerTrain;
        this.year = year;
        this.unit = unit;
        this.value = value;
    }
}

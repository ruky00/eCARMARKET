package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Market {
    @Id
    private String countryName;

    private String info;

    public String getCountryName() { return countryName; }

    public void setCountryName(String countryName) { this.countryName = countryName; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public Market(String countryName, String info) {
        this.countryName = countryName;
        this.info = info;
    }
}

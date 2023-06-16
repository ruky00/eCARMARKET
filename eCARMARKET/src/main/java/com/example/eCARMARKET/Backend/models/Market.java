package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Market {
    @Id
    private String countryName;

    private Object info;

    public String getCountryName() { return countryName; }

    public void setCountryName(String countryName) { this.countryName = countryName; }

    public Object getInfo() { return info; }

    public void setInfo(Object info) { this.info = info; }

    public Market(String countryName, Object info) {
        this.countryName = countryName;
        this.info = info;
    }
}

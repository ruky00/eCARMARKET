package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GlobalDataSection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String info;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public GlobalDataSection(long id, String info){
        this.id = id;
        this.info = info;
    }
}

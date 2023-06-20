package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GlobalDataSection {

    @Id
    private String sectionName;

    private String info;

    public String getSectionName() { return sectionName; }

    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public GlobalDataSection(String sectionName, String info){
        this.sectionName = sectionName;
        this.info = info;
    }
}

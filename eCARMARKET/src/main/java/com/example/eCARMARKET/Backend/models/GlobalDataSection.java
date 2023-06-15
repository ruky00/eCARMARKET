package com.example.eCARMARKET.Backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GlobalDataSection {

    @Id
    private String sectionName;

    private Object info;

    public String getSectionName() { return sectionName; }

    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public Object getInfo() { return info; }

    public void setInfo(Object info) { this.info = info; }

    public GlobalDataSection(String sectionName, Object info){
        this.sectionName = sectionName;
        this.info = info;
    }
}

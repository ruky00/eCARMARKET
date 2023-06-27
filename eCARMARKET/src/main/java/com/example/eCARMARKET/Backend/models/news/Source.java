package com.example.eCARMARKET.Backend.models.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {


    @JsonProperty("name")
    private String name;



    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public Source(){}

    public Source(String name){
        this.name= name;
    }


}

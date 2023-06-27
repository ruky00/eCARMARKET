package com.example.eCARMARKET.Backend.models.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {

    @Id
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}

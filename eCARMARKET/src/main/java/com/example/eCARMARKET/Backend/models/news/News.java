package com.example.eCARMARKET.Backend.models.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("totalResults")
    private int totalResults;

    @JsonProperty("articles")
    @OneToMany(mappedBy = "news")
    private Set<Article> articles;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getTotalResults() { return totalResults; }

    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }

    public Set<Article> getArticles() { return articles; }

    public void setArticles(Set<Article> articles) { this.articles = articles; }

    public void addArticles(Article article) { articles.add(article); }

    public void removeArticles(Article article) { articles.remove(article); }
}

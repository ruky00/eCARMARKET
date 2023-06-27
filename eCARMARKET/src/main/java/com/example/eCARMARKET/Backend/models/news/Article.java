package com.example.eCARMARKET.Backend.models.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.net.URL;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("source")
    private Source source;

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private URL url;

    @JsonProperty("urlToImage")
    private URL urlToImage;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("content")
    private String content;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Source getSource() { return source; }

    public void setSource(Source source) { this.source = source; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public URL getUrl() { return url; }

    public void setUrl(URL url) { this.url = url; }

    public URL getUrlToImage() { return urlToImage; }

    public void setUrlToImage(URL urlToImage) { this.urlToImage = urlToImage; }

    public String getPublishedAt() { return publishedAt; }

    public void setPublishedAt(String publishedAt) { this.publishedAt = publishedAt; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}

package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.news.News;
import com.example.eCARMARKET.Backend.repositories.NewsRepository;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    NewsApiClient newsApiClient= new NewsApiClient("7c72a80e39d84bb0b085084474b70b4e");

    public void save(News news){
        newsRepository.save(news);
    }

    public List<News> getAll(){
        return newsRepository.findAll();
    }

    public void getTesla(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("tesla")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        System.out.println(articleResponse.getArticles().get(0).getTitle());
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
    }

    public void getNewsElectricCars(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("electric cars")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        System.out.println(articleResponse.getArticles().get(0).getTitle());
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
    }

    public void getNewsFor(String subject){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(subject)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        System.out.println(articleResponse.getArticles().get(0).getTitle());
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
    }

}

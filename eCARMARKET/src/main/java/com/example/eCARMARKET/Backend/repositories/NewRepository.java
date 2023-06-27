package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewRepository extends JpaRepository<News, Long> {
}

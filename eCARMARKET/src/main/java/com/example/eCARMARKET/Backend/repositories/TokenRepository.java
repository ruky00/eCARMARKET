package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<ConfirmationToken,Long> {
    Optional<ConfirmationToken> findByConfirmationToken(String token);
}


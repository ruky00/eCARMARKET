package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<ConfirmationToken,Long> {
  //  ConfirmationToken findToken(String token);
}

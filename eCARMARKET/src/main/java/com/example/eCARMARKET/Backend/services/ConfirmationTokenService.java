package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.ConfirmationToken;
import com.example.eCARMARKET.Backend.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        tokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return tokenRepository.findByConfirmationToken(token);
    }
}




package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.Profile;
import com.example.eCARMARKET.Backend.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Profile> findByClientEmail(String clientEmail) {
        return profileRepository.findByClientEmail(clientEmail);
    }

}

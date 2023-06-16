package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

}

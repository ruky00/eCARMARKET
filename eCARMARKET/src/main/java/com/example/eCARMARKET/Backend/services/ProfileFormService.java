package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.ProfileForm;
import com.example.eCARMARKET.Backend.repositories.ProfileFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileFormService {

    @Autowired
    private ProfileFormRepository profileFormRepository;

    public Optional<ProfileForm> getProfileForm(Long id){
        return profileFormRepository.findById(id);
    }

    public void save(ProfileForm profileForm){
        profileFormRepository.save(profileForm);
    }

}

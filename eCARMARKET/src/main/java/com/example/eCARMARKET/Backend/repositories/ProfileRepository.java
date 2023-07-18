package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByClientEmail(String clientEmail);

}

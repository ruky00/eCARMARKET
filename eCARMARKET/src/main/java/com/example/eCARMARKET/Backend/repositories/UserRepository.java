package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByEmail(String email);


}

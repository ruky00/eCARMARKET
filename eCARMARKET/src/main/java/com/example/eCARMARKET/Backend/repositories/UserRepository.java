package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

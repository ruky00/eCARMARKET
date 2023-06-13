package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.User;
import com.example.eCARMARKET.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   public void save(User user){
       userRepository.save(user);
   }

   public Optional<User> findByEmail(String email){
       return userRepository.findByEmail(email);
   }

   public Optional<User> findById(Long id){
       return userRepository.findById(id);
   }

}

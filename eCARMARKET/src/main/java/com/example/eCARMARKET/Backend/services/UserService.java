package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   public void save(Client user){
       userRepository.save(user);
   }

   public Optional<Client> findByEmail(String email){
       return userRepository.findByEmail(email);
   }

   public Optional<Client> findById(Long id){
       return userRepository.findById(id);
   }

}

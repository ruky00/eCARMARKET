package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

   @Autowired
   private ClientRepository clientRepository;

   public void save(Client user){
       clientRepository.save(user);
   }

   public Optional<Client> findByEmail(String email){
       return clientRepository.findByEmail(email);
   }

   public Optional<Client> findById(Long id){
       return clientRepository.findById(id);
   }

}

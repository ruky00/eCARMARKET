package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.repositories.GlobalDataSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalDataSectionService {

    @Autowired
    private GlobalDataSectionRepository globalDataSectionRepository;

}

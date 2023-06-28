package com.example.eCARMARKET.Backend.services;

import com.example.eCARMARKET.Backend.models.GlobalDataSection;
import com.example.eCARMARKET.Backend.repositories.GlobalDataSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class GlobalDataSectionService {

    @Autowired
    private GlobalDataSectionRepository globalDataSectionRepository;

    public Optional<GlobalDataSection> findById(long id) {
        return globalDataSectionRepository.findById(id);
    }
    
}

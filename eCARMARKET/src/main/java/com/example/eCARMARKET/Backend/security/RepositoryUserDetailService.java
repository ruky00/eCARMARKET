package com.example.eCARMARKET.Backend.security;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RepositoryUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + "USER"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getEncodedPassword(), roles);

    }
}

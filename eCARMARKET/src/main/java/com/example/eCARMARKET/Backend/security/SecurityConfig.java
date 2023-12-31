package com.example.eCARMARKET.Backend.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RepositoryUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginError");

        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

}
package com.example.eCARMARKET.Backend.repositories;

import com.example.eCARMARKET.Backend.models.ProfileForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileFormRepository extends JpaRepository<ProfileForm,Long> {

}

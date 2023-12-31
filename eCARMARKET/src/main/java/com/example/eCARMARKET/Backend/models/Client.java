package com.example.eCARMARKET.Backend.models;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String surname;

    private String email;

    private String occupation;

    private boolean permission;

    private boolean isEnabled;

    private Blob imageFile;
    @OneToOne(cascade = CascadeType.ALL)
    private ProfileForm profileForm;

    public ProfileForm getProfileForm() {
        return profileForm;
    }

    public void setProfileForm(ProfileForm profileForm) {
        this.profileForm = profileForm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    private String encodedPassword;

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }

    public Client(){}

    public Client(String name, String surname, String email, String occupation, boolean permission, String encodedPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.occupation = occupation;
        this.permission = permission;
        this.encodedPassword = encodedPassword;
    }
}

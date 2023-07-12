package com.example.eCARMARKET.Backend.models;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfileForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rol;

    private String org;

    private ArrayList<String> favCompany;

    private boolean allowOverview;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public ArrayList<String> getFavCompany() {
        return favCompany;
    }

    public void setFavCompany(ArrayList<String> favCompany) {
        this.favCompany = favCompany;
    }

    public boolean isAllowOverview() {
        return allowOverview;
    }

    public void setAllowOverview(boolean allowOverview) {
        this.allowOverview = allowOverview;
    }

    public ProfileForm(){}

    public ProfileForm(String rol, String org, ArrayList<String> favCompany, boolean allowOverview){
        this.rol=rol;
        this.org=org;
        this.favCompany=favCompany;
        this.allowOverview=allowOverview;
    }


}

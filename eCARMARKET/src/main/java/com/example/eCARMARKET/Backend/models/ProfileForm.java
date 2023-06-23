package com.example.eCARMARKET.Backend.models;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
public class ProfileForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rol;

    private String org;

    private String thingsToDo;

    private String favCompany;

    private boolean allowOverview;

    @OneToOne(mappedBy = "profileForm")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public String getThingsToDo() {
        return thingsToDo;
    }

    public void setThingsToDo(String thingsToDo) {
        this.thingsToDo = thingsToDo;
    }

    public String getFavCompany() {
        return favCompany;
    }

    public void setFavCompany(String favCompany) {
        this.favCompany = favCompany;
    }

    public boolean isAllowOverview() {
        return allowOverview;
    }

    public void setAllowOverview(boolean allowOverview) {
        this.allowOverview = allowOverview;
    }

    public ProfileForm(){}

    public ProfileForm(String rol,String org, String thingsToDo,String favCompany, boolean allowOverview){
        this.rol=rol;
        this.org=org;
        this.thingsToDo=thingsToDo;
        this.favCompany=favCompany;
        this.allowOverview=allowOverview;
    }


}

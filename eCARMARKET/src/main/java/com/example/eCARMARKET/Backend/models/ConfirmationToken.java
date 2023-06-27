package com.example.eCARMARKET.Backend.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;


    private LocalDateTime createdDate;
    private LocalDateTime expireAt;
    private LocalDateTime comfirmTime;

    @ManyToOne
    private Client client;
    public long getTokenid() {
        return tokenid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public LocalDateTime getComfirmTime() {
        return comfirmTime;
    }

    public void setComfirmTime(LocalDateTime comfirmTime) {
        this.comfirmTime = comfirmTime;
    }
    public ConfirmationToken(){
    }

    public ConfirmationToken(String token,LocalDateTime createdDate,LocalDateTime expireAt, Client client){
        this.confirmationToken = token;
        this.createdDate = createdDate;
        this.expireAt = expireAt;
        this.client = client;
    }
}


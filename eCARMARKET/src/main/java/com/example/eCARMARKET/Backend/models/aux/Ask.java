package com.example.eCARMARKET.Backend.models.aux;

public class Ask {
    private double price;
    private double numberOfShares;

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public double getNumberOfShares() { return numberOfShares; }

    public void setNumberOfShares(double numberOfShares) { this.numberOfShares = numberOfShares; }

    public String toString(){
        return price + " x " + numberOfShares;
    }

    public Ask(double price, double numberOfShares) {
        this.price = price;
        this.numberOfShares = numberOfShares;
    }
}

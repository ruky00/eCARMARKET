package com.example.eCARMARKET.Backend.models.aux;

public class ValueWithUnit {

    private double value;
    private String unit;

    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public String toString(){
        return value + unit;
    }

    public ValueWithUnit(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }
}

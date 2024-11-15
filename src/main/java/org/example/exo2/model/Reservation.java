package org.example.exo2.model;

import java.util.ArrayList;

public class Reservation {
    private AppartType type;
    private double price;
    private ArrayList<OptionsType> options;

    public Reservation() {
        this.options = new ArrayList<>();
    }

    public AppartType getType() {
        return type;
    }

    public void setType(AppartType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<OptionsType> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionsType> options) {
        this.options = options;
    }
}

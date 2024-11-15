package org.example.exo2.model;

public enum OptionsType {
    SEA("Proche de la mer"),
    POOL("Piscine"),
    GARDEN("Jardin");

    private final String name;

    OptionsType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

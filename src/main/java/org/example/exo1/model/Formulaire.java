package org.example.exo1.model;


import java.util.List;


public class Formulaire {
    private String nom;
    private String prenom;
    private String genre;
    private String codePostal;
    private List<String> transports;

    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public List<String> getTransports() { return transports; }
    public void setTransports(List<String> transports) { this.transports = transports; }
}

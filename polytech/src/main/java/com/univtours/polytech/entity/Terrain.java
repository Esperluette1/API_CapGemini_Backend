package com.univtours.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "terrain")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "description")
    private String description;

    @Column(name = "coordonnees_id")
    private Integer coordonneesId;

    public Terrain() {
    }

    public Terrain(Long id, String nom, Integer quantite, String description, Integer coordonneesId) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
        this.coordonneesId = coordonneesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoordonneesId() {
        return coordonneesId;
    }

    public void setCoordonneesId(Integer coordonneesId) {
        this.coordonneesId = coordonneesId;
    }
}

package com.univtours.polytech.dto;

public class TerrainDTO {
    private Long id;
    private String nom;
    private Integer quantite;
    private String description;
    private Integer coordonneesId;

    public TerrainDTO() {
    }

    public TerrainDTO(Long id, String nom, Integer quantite, String description, Integer coordonneesId) {
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
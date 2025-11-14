package com.univtours.polytech.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TerrainDTO {
    private int id;
    private String nom;
    private int quantite;
    private String description;
    private int coordonnees_id;
}

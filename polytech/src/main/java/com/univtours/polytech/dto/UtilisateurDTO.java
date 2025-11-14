package com.univtours.polytech.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UtilisateurDTO {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String username;
}
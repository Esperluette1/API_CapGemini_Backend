package com.univtours.polytech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity 
@Table(name = "utilisateur")
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String username;
}

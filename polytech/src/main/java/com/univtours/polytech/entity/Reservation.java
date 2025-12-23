package com.univtours.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation")
    private Integer reservation;

    @Column(name = "utilisateur_id")
    private Integer utilisateur_id;

    @Column(name = "terrain_id")
    private Integer terrain_id;

    public Reservation() {
    }

    public Reservation(Integer reservation, Integer utilisateur_id, Integer terrain_id) {
        this.reservation = reservation;
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }

    public Integer getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(Integer utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Integer getTerrain_id() {
        return terrain_id;
    }

    public void setTerrain_id(Integer terrain_id) {
        this.terrain_id = terrain_id;
    }
}
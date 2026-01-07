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
    private Long reservation;

    @Column(name = "utilisateur_id")
    private Long utilisateur_id;

    @Column(name = "terrain_id")
    private Long terrain_id;

    public Reservation() {
    }

    public Reservation(Long reservation, Long utilisateur_id, Long terrain_id) {
        this.reservation = reservation;
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
    }

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {
        this.reservation = reservation;
    }

    public Long getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(Long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Long getTerrain_id() {
        return terrain_id;
    }

    public void setTerrain_id(Long terrain_id) {
        this.terrain_id = terrain_id;
    }
}
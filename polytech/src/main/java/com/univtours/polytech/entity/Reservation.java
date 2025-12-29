package com.univtours.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
@IdClass(ReservationId.class)
public class Reservation implements Serializable {

    @Id
    @Column(name = "utilisateur_id")
    private Integer utilisateur_id;

    @Id
    @Column(name = "terrain_id")
    private Integer terrain_id;

    @Column(name = "reservation")
    private Integer reservation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "terrain_id", insertable = false, updatable = false)
    private Terrain terrain;

    public Reservation() {
    }

    public Reservation(Integer utilisateur_id, Integer terrain_id, Integer reservation) {
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
        this.reservation = reservation;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
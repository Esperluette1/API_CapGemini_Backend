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

    @Column(name = "reservation")
    private Long reservation;

    @Id
    @Column(name = "utilisateur_id")
    private Long utilisateur_id;

    @Id
    @Column(name = "terrain_id")
    private Long terrain_id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "terrain_id", insertable = false, updatable = false)
    private Terrain terrain;

    public Reservation() {
    }

    public Reservation(Long reservation, Long utilisateur_id, Long terrain_id) {
        this.reservation = reservation;
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
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

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {
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
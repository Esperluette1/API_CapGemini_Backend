package com.univtours.polytech.dto;

public class ReservationDTO {
    private Long utilisateurId;
    private Long terrainId;
    private Long reservation;

    public ReservationDTO() {
    }

    public ReservationDTO(Long utilisateur_id, Long terrain_id, Long reservation) {
        this.utilisateurId = utilisateur_id;
        this.terrainId = terrain_id;
        this.reservation = reservation;
    }

    public Long getUtilisateur_id() {
        return utilisateurId;
    }

    public void setUtilisateur_id(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getTerrain_id() {
        return terrainId;
    }

    public void setTerrain_id(Long terrain_id) {
        this.terrainId = terrainId;
    }

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {this.reservation = reservation;}
    }

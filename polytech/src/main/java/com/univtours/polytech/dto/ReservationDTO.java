package com.univtours.polytech.dto;

public class ReservationDTO {
    private Integer utilisateur_id;
    private Integer terrain_id;
    private Integer reservation;

    public ReservationDTO() {
    }

    public ReservationDTO(Integer utilisateur_id, Integer terrain_id, Integer reservation) {
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
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

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }
}

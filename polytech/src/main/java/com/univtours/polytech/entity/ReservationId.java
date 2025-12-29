package com.univtours.polytech.entity;

import java.io.Serializable;
import java.util.Objects;

public class ReservationId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer utilisateur_id;
    private Integer terrain_id;

    public ReservationId() {
    }

    public ReservationId(Integer utilisateur_id, Integer terrain_id) {
        this.utilisateur_id = utilisateur_id;
        this.terrain_id = terrain_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId that = (ReservationId) o;
        return Objects.equals(utilisateur_id, that.utilisateur_id) &&
                Objects.equals(terrain_id, that.terrain_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur_id, terrain_id);
    }
}

package com.univtours.polytech.entity;

import java.io.Serializable;
import java.util.Objects;

public class ReservationId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long utilisateur_id;
    private Long terrain_id;

    public ReservationId() {
    }

    public ReservationId(Long utilisateur_id, Long terrain_id) {
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
package com.univtours.polytech.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("Select COUNT(r) FROM Reservation r WHERE r.terrain_id = ?1")
    long countByTerrainId(long terrainId);
}
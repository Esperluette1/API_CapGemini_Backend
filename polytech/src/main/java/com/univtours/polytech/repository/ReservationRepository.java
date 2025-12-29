package com.univtours.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.entity.ReservationId;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

}
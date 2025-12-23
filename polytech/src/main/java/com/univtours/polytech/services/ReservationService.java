package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.repository.ReservationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    // Create
    public void createReservation(Reservation reservation) {
        if (reservation != null){
            reservationRepository.save(reservation);
        }  
    }

    // Read Unitaire
    public Reservation readReservation(Integer ID) {
        Optional<Reservation> reservation = reservationRepository.findById(ID);
        if (reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        return reservation.get();
    }

    // Read par Liste
    public List<Reservation> readAllReservations() {
        return reservationRepository.findAll();
    }

    // Update
    public void updateReservation(Integer reservation_ID, Integer user_ID, Integer terrain_ID, Integer reservation_value) {
        Optional<Reservation> reservation = reservationRepository.findById(reservation_ID);
        if (reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        reservation.get().setReservation(reservation_value);
        reservation.get().setUtilisateur_id(user_ID);
        reservation.get().setTerrain_id(terrain_ID);
        reservationRepository.save(reservation.get());
    }

    // Delete
    public void deleteReservation(Integer ID) {
        if (!reservationRepository.existsById(ID)) {
            throw new EntityNotFoundException("La reservation n'existe pas");
        }
        reservationRepository.deleteById(ID);
    }
}

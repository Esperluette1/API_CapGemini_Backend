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
    public Reservation readReservation(int ID) {
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
    public void updateReservation(int user_ID, int terrain_ID, int reservation_ID) {
        Optional<Reservation> Reservation = reservationRepository.findById(reservation_ID);
        if (Reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        Reservation.get().setReservation(reservation_ID);
        Reservation.get().setUtilisateur_id(user_ID);
        Reservation.get().setTerrain_id(terrain_ID);
    }

    // Delete
    public void deleteReservation(int ID) {
        if (!reservationRepository.existsById(ID)) {
            throw new EntityNotFoundException("La reservation n'existe pas");
        }
        reservationRepository.deleteById(ID);
    }
}
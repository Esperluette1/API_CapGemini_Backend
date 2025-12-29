package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.entity.ReservationId;
import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.repository.ReservationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    // Create
    public void createReservation(Reservation reservation) {
        if (reservation != null && reservation.getUtilisateur() != null && reservation.getTerrain() != null){
            reservationRepository.save(reservation);
        } else {
            throw new EntityNotFoundException("Reservation, utilisateur and terrain cannot be null");
        }  
    }

    // Read Unitaire
    public Reservation readReservation(Integer utilisateur_id, Integer terrain_id) {
        ReservationId id = new ReservationId(utilisateur_id, terrain_id);
        Optional<Reservation> reservation = reservationRepository.findById(id);
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
    public void updateReservation(Integer utilisateur_id, Integer terrain_id, Utilisateur utilisateur, Terrain terrain, Integer reservation_value) {
        ReservationId id = new ReservationId(utilisateur_id, terrain_id);
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        reservation.get().setReservation(reservation_value);
        reservation.get().setUtilisateur(utilisateur);
        reservation.get().setTerrain(terrain);
        reservationRepository.save(reservation.get());
    }

    // Delete
    public void deleteReservation(Integer utilisateur_id, Integer terrain_id) {
        ReservationId id = new ReservationId(utilisateur_id, terrain_id);
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("La reservation n'existe pas");
        }
        reservationRepository.deleteById(id);
    }
}

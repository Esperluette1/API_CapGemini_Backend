package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.repository.ReservationRepository;
import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.repository.TerrainRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TerrainRepository terrainRepository;

    // Create
    public void createReservation(Reservation reservation) {
        if (reservation != null){
            Long terrainId = reservation.getTerrain_id();
            Terrain terrain = terrainRepository.findById(terrainId)
                    .orElseThrow(() -> new EntityNotFoundException("Terrain introuvable"));

            long nbRes = reservationRepository.countByTerrainId(reservation.getTerrain_id());

            if(nbRes >= terrain.getQuantite()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Terrain complet");
            }

            reservationRepository.save(reservation);
        }
    }

    // Read Unitaire
    public Reservation readReservation(Long ID) {
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
    public void updateReservation(Long reservation_ID, Long user_ID, Long terrain_ID, Long reservation_value) {
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
    public void deleteReservation(Long ID) {
        if (!reservationRepository.existsById(ID)) {
            throw new EntityNotFoundException("La reservation n'existe pas");
        }
        reservationRepository.deleteById(ID);
    }
}

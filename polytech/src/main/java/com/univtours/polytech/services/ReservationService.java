package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import jakarta.persistence.EntityNotFoundException;

import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.repository.ReservationRepository;
import com.univtours.polytech.repository.TerrainRepository;
import com.univtours.polytech.repository.UtilisateurRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // CREATE
    @SuppressWarnings("null")
    public void createReservation(Reservation reservation) {
        if (reservation != null){
            Long terrainId = reservation.getTerrain().getId();
            Terrain terrain = terrainRepository.findById(terrainId)
                    .orElseThrow(() -> new EntityNotFoundException("Terrain introuvable"));

            long nbRes = reservationRepository.countByTerrainId(reservation.getTerrain().getId());
            if(nbRes >= terrain.getQuantite()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Terrain complet");
            }

            reservationRepository.save(reservation);
        }
    }

    // READ unitaire
    @SuppressWarnings("null")
    public Reservation readReservation(Long ID) {
        Optional<Reservation> reservation = reservationRepository.findById(ID);
        if (reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        return reservation.get();
    }

    // READ liste
    public List<Reservation> readAllReservations() {return reservationRepository.findAll();}

    // UPDATE
    @SuppressWarnings("null")
    public void updateReservation(Long reservation_ID, Long user_ID, Long terrain_ID, Long reservation_value) {
        Optional<Reservation> reservation = reservationRepository.findById(reservation_ID);
        if (reservation.isEmpty()) {
            throw new EntityNotFoundException("Reservation non trouvé");
        }
        
        Terrain terrain = terrainRepository.findById(terrain_ID)
                .orElseThrow(() -> new EntityNotFoundException("Terrain introuvable"));
        
        Utilisateur utilisateur = utilisateurRepository.findById(user_ID)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));
        
        reservation.get().setReservation(reservation_value);
        reservation.get().setUtilisateur(utilisateur);
        reservation.get().setTerrain(terrain);
        reservationRepository.save(reservation.get());
    }

    // DELETE
    @SuppressWarnings("null")
    public void deleteReservation(Long ID) {
        if (!reservationRepository.existsById(ID)) {
            throw new EntityNotFoundException("La reservation n'existe pas");
        }
        reservationRepository.deleteById(ID);
    }
}
package com.univtours.polytech.Controller;

import com.univtours.polytech.mapper.ReservationMapper;
import com.univtours.polytech.services.ReservationService;
import com.univtours.polytech.services.UtilisateurService;
import com.univtours.polytech.services.TerrainService;
import com.univtours.polytech.dto.ReservationDTO;
import com.univtours.polytech.entity.Reservation;
import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.entity.Terrain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private ReservationMapper reservationMapper;

    // CREATE
    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO dto) {
        if (dto.getUtilisateur_id() == null || dto.getTerrain_id() == null) {
            throw new EntityNotFoundException("utilisateur_id and terrain_id are required");
        }
        
        Utilisateur utilisateur = utilisateurService.readUser(Long.valueOf(dto.getUtilisateur_id()));
        Terrain terrain = terrainService.readTerrain(Long.valueOf(dto.getTerrain_id()));
        
        Reservation entity = reservationMapper.toEntity(dto);
        entity.setUtilisateur(utilisateur);
        entity.setTerrain(terrain);
        
        reservationService.createReservation(entity);
        ReservationDTO response = reservationMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{utilisateur_id}/{terrain_id}")
    public ResponseEntity<ReservationDTO> getReservation(
            @PathVariable Integer utilisateur_id,
            @PathVariable Integer terrain_id) {
        Reservation entity = reservationService.readReservation(utilisateur_id, terrain_id);
        ReservationDTO dto = reservationMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> entities = reservationService.readAllReservations();
        List<ReservationDTO> dtos =
                entities.stream()
                        .map(reservationMapper::toDTO)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{utilisateur_id}/{terrain_id}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable Integer utilisateur_id,
            @PathVariable Integer terrain_id,
            @RequestBody ReservationDTO dto
    ) {
        Utilisateur utilisateur = utilisateurService.readUser(Long.valueOf(utilisateur_id));
        Terrain terrain = terrainService.readTerrain(Long.valueOf(terrain_id));
        reservationService.updateReservation(
                utilisateur_id,
                terrain_id,
                utilisateur,
                terrain,
                dto.getReservation()
        );
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{utilisateur_id}/{terrain_id}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable Integer utilisateur_id,
            @PathVariable Integer terrain_id) {
        reservationService.deleteReservation(utilisateur_id, terrain_id);
        return ResponseEntity.noContent().build();
    }
}
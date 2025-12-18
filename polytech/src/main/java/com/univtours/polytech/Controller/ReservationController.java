package com.univtours.polytech.Controller;

import com.univtours.polytech.mapper.ReservationMapper;
import com.univtours.polytech.services.ReservationService;
import com.univtours.polytech.dto.ReservationDTO;
import com.univtours.polytech.entity.Reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;

    // CREATE
    @PostMapping
    public ResponseEntity<ReservationDTO> createReservEntity(@RequestBody ReservationDTO dto) {
        Reservation entity = reservationMapper.toEntity(dto);
        reservationService.createReservation(entity);
        ReservationDTO response = reservationMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable int id) {
        Reservation entity = reservationService.readReservation(id);
        ReservationDTO dto = reservationMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> entities = ReservationService.readAllReservations();
        List<ReservationDTO> dtos =
                entities.stream()
                        .map(reservationMapper::toDTO)
                        .toList();

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable int id,
            @RequestBody ReservationDTO dto
    ) {
        Reservation entity = reservationMapper.toEntity(dto);
        reservationService.updateReservation(
                entity.getUtilisateur_id(),
                entity.getTerrain_id(),
                entity.getReservation()
        );
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
package com.univtours.polytech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.univtours.polytech.dto.CoordonneesDTO;
import com.univtours.polytech.entity.Coordonnees;
import com.univtours.polytech.mapper.CoordonneesMapper;
import com.univtours.polytech.services.CoordonneesService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coordonnees")
@CrossOrigin(origins = "*")
public class CoordonneesController {

    @Autowired
    private CoordonneesService coordonneesService;

    @Autowired
    private CoordonneesMapper coordonneesMapper;

    // CREATE
    @PostMapping
    public ResponseEntity<CoordonneesDTO> createCoordonnees(@RequestBody CoordonneesDTO dto) {
        Coordonnees entity = coordonneesMapper.toEntity(dto);
        coordonneesService.createCoordonnees(entity);
        CoordonneesDTO response = coordonneesMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{id}")
    public ResponseEntity<CoordonneesDTO> getCoordonnees(@PathVariable Long id) {
        Coordonnees entity = coordonneesService.readCoordonnees(id);
        CoordonneesDTO dto = coordonneesMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<CoordonneesDTO>> getAllCoordonnees() {
        List<Coordonnees> entities = coordonneesService.readAllCoordonnees();
        List<CoordonneesDTO> dtos = entities.stream().map(coordonneesMapper::toDTO).toList();

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCoordonnees(@PathVariable Long id, @RequestBody CoordonneesDTO dto) {
        Coordonnees entity = coordonneesMapper.toEntity(dto);
        coordonneesService.updateCoordonnees(id, entity.getLongitude(), entity.getLatitude());
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordonnees(@PathVariable Long id) {
        coordonneesService.deleteCoordonnees(id);
        return ResponseEntity.noContent().build();
    }
}

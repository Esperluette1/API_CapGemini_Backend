package com.univtours.polytech.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.univtours.polytech.dto.TerrainDTO;
import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.entity.Coordonnees;
import com.univtours.polytech.mapper.TerrainMapper;
import com.univtours.polytech.services.TerrainService;
import com.univtours.polytech.repository.CoordonneesRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/terrains")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private TerrainMapper terrainMapper;

    @Autowired
    private CoordonneesRepository coordonneesRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<TerrainDTO> createTerrain(@RequestBody TerrainDTO dto) {
        Terrain entity = terrainMapper.toEntity(dto);
        
        // Charger les coordonnées à partir de l'ID fourni dans le DTO
        if (dto.getCoordonneesId() != null) {
            Coordonnees coordonnees = coordonneesRepository.findById(dto.getCoordonneesId())
                .orElseThrow(() -> new EntityNotFoundException("Coordonnees with id " + dto.getCoordonneesId() + " not found"));
            entity.setCoordonnees(coordonnees);
        } else {
            throw new EntityNotFoundException("coordonneesId is required");
        }
        
        terrainService.createTerrain(entity);
        TerrainDTO response = terrainMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{id}")
    public ResponseEntity<TerrainDTO> getTerrain(@PathVariable Long id) {
        Terrain entity = terrainService.readTerrain(id);
        TerrainDTO dto = terrainMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<TerrainDTO>> getAllTerrains() {
        List<Terrain> entities = terrainService.readAllTerrains();
        List<TerrainDTO> dtos = entities.stream().map(terrainMapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTerrain(
            @PathVariable Long id,
            @RequestBody TerrainDTO dto
    ) {
        Terrain entity = terrainMapper.toEntity(dto);
        
        // Charger les coordonnées si fourni
        Coordonnees coordonnees = null;
        if (dto.getCoordonneesId() != null) {
            coordonnees = coordonneesRepository.findById(dto.getCoordonneesId())
                .orElseThrow(() -> new EntityNotFoundException("Coordonnees with id " + dto.getCoordonneesId() + " not found"));
        }
        
        terrainService.updateTerrain(
                id,
                entity.getNom(),
                entity.getQuantite(),
                entity.getDescription(),
                coordonnees
        );
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.noContent().build();
    }
}
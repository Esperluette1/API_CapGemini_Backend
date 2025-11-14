package com.univtours.polytech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.univtours.polytech.dto.TerrainDTO;
import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.mapper.TerrainMapper;
import com.univtours.polytech.services.TerrainService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/terrains")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private TerrainMapper terrainMapper;

    // CREATE
    @PostMapping
    public ResponseEntity<TerrainDTO> createTerrain(@RequestBody TerrainDTO dto) {
        Terrain entity = terrainMapper.toEntity(dto);
        terrainService.createTerrain(entity);
        TerrainDTO response = terrainMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{id}")
    public ResponseEntity<TerrainDTO> getTerrain(@PathVariable int id) {
        Terrain entity = terrainService.readTerrain(id);
        TerrainDTO dto = terrainMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<TerrainDTO>> getAllTerrains() {
        List<Terrain> entities = terrainService.readAllTerrains();
        List<TerrainDTO> dtos =
                entities.stream()
                        .map(terrainMapper::toDTO)
                        .toList();

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTerrain(
            @PathVariable int id,
            @RequestBody TerrainDTO dto
    ) {
        Terrain entity = terrainMapper.toEntity(dto);
        terrainService.updateTerrain(
                id,
                entity.getNom(),
                entity.getQuantite(),
                entity.getDescription(),
                entity.getCoordonnees_id()
        );
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable int id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.noContent().build();
    }
}
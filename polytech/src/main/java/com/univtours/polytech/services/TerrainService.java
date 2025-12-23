package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.repository.TerrainRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TerrainService {
    @Autowired
    private TerrainRepository terrainRepository;

    // Create
    public void createTerrain(Terrain terrain) {
        if (terrain != null){
            terrainRepository.save(terrain);
        }
    }

    // Read Unitaire
    public Terrain readTerrain(Long ID) {
        Optional<Terrain> terrain = terrainRepository.findById(ID);
        if (terrain.isEmpty()) {
            throw new EntityNotFoundException("Terrain non trouvé");
        }
        return terrain.get();
    }

    // Read par Liste
    public List<Terrain> readAllTerrains() {
        return terrainRepository.findAll();
    }

    // Update
    public void updateTerrain(Long ID, String nom, Integer quantite, String description, Integer coordonnees_id) {
        Optional<Terrain> terrain = terrainRepository.findById(ID);
        if (terrain.isEmpty()) {
            throw new EntityNotFoundException("Terrain non trouvé");
        }
        terrain.get().setNom(nom);
        terrain.get().setQuantite(quantite);
        terrain.get().setDescription(description);
        terrain.get().setCoordonneesId(coordonnees_id);
        terrainRepository.save(terrain.get());
    }

    // Delete
    public void deleteTerrain(Long ID) {
        if (!terrainRepository.existsById(ID)) {
            throw new EntityNotFoundException("Le terrain n'existe pas");
        }
        terrainRepository.deleteById(ID);
    }
}

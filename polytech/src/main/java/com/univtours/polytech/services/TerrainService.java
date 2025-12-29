package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Terrain;
import com.univtours.polytech.entity.Coordonnees;
import com.univtours.polytech.repository.TerrainRepository;
import com.univtours.polytech.repository.CoordonneesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TerrainService {
    @Autowired
    private TerrainRepository terrainRepository;
    
    @Autowired
    private CoordonneesRepository coordonneesRepository;

    // Create
    public void createTerrain(Terrain terrain) {
        if (terrain != null && terrain.getCoordonnees() != null){
            terrainRepository.save(terrain);
        } else {
            throw new EntityNotFoundException("Terrain and coordonnees cannot be null");
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
    public void updateTerrain(Long ID, String nom, Integer quantite, String description, Coordonnees coordonnees) {
        Optional<Terrain> terrain = terrainRepository.findById(ID);
        if (terrain.isEmpty()) {
            throw new EntityNotFoundException("Terrain non trouvé");
        }
        terrain.get().setNom(nom);
        terrain.get().setQuantite(quantite);
        terrain.get().setDescription(description);
        terrain.get().setCoordonnees(coordonnees);
        terrainRepository.save(terrain.get());
    }

    // Delete
    public void deleteTerrain(Long ID) {
        if (!terrainRepository.existsById(ID)) {
            throw new EntityNotFoundException("Le terrain n'existe pas");
        }
        
        // Récupérer le terrain pour obtenir ses coordonnées
        Optional<Terrain> terrainOpt = terrainRepository.findById(ID);
        if (terrainOpt.isPresent()) {
            Terrain terrain = terrainOpt.get();
            Coordonnees coordonnees = terrain.getCoordonnees();
            
            // Supprimer le terrain
            terrainRepository.deleteById(ID);
            
            // Vérifier si d'autres terrains utilisent ces coordonnées
            if (coordonnees != null) {
                long count = terrainRepository.findAll().stream()
                    .filter(t -> t.getCoordonnees() != null && t.getCoordonnees().getId().equals(coordonnees.getId()))
                    .count();
                
                // Si aucun autre terrain n'utilise ces coordonnées, les supprimer
                if (count == 0) {
                    coordonneesRepository.deleteById(coordonnees.getId());
                }
            }
        }
    }
}

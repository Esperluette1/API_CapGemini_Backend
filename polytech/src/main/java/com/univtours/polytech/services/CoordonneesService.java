package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Coordonnees;
import com.univtours.polytech.repository.CoordonneesRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CoordonneesService {
    @Autowired
    private CoordonneesRepository coordonneesRepository;

    // Create
    public void createCoordonnees(Coordonnees coordonnees) {
        if (coordonnees != null){
            coordonneesRepository.save(coordonnees);
        }
    }

    // Read Unitaire
    public Coordonnees readCoordonnees(Long id) {
        Optional<Coordonnees> coordonnees = coordonneesRepository.findById(id);
        if (coordonnees.isEmpty()) {
            throw new EntityNotFoundException("Coordonnees non trouvé");
        }
        return coordonnees.get();
    }

    // Read par Liste
    public List<Coordonnees> readAllCoordonnees() {
        return coordonneesRepository.findAll();
    }

    // Update
    public void updateCoordonnees(Long ID, float longitude, float latitude) {
        Optional<Coordonnees> coordonnees = coordonneesRepository.findById(ID);
        if (coordonnees.isEmpty()) {
            throw new EntityNotFoundException("Coordonnees non trouvé");
        }
        coordonnees.get().setLongitude(longitude);
        coordonnees.get().setLatitude(latitude);
        coordonneesRepository.save(coordonnees.get());
    }

    // Delete
    public void deleteCoordonnees(Long ID) {
        if (!coordonneesRepository.existsById(ID)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordonnées introuvables");
        }
        // Ne pas supprimer si des terrains référencent ces coordonnées (respecter script BDD)
        Coordonnees coordonnees = coordonneesRepository.findById(ID).get();
        boolean referenced = coordonnees.getTerrains() != null && !coordonnees.getTerrains().isEmpty();
        if (referenced) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Impossible de supprimer : références existantes (terrain)");
        }
        try {
            coordonneesRepository.deleteById(ID);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Échec suppression coordonnées", ex);
        }
    }
}

package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Coordonnees;
import com.univtours.polytech.repository.CoordonneesRepository;

import jakarta.persistence.EntityNotFoundException;

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
    public Coordonnees readCoordonnees(int ID) {
        Optional<Coordonnees> coordonnees = coordonneesRepository.findById(ID);
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
    public void updateCoordonnees(int ID, float longitude, float latitude) {
        Optional<Coordonnees> coordonnees = coordonneesRepository.findById(ID);
        if (coordonnees.isEmpty()) {
            throw new EntityNotFoundException("Coordonnees non trouvé");
        }
        coordonnees.get().setLongitude(longitude);
        coordonnees.get().setLatitude(latitude);
    }

    // Delete
    public void deleteCoordonnees(int ID) {
        if (!coordonneesRepository.existsById(ID)) {
            throw new EntityNotFoundException("Le coordonnees n'existe pas");
        }
        coordonneesRepository.deleteById(ID);
    }
}

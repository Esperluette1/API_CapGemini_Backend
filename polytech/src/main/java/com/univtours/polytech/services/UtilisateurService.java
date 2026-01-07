package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.repository.UtilisateurRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepository;

    // Create
    public void createUser(Utilisateur user) {
        if (user != null) {
            userRepository.save(user);
        }
    }

    // Read Unitaire
    public Utilisateur readUser(Long id) {
        Optional<Utilisateur> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Utilisateur non trouvé");
        }
        return user.get();
    }

    // Read par Liste
    public List<Utilisateur> readAllUsers() {
        return userRepository.findAll();
    }

    // Update
    public void updateUser(Long ID, String nom, String prenom, String mail, String password, String username) {
        Optional<Utilisateur> user = userRepository.findById(ID);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Utilisateur non trouvé");
        }
        user.get().setNom(nom);
        user.get().setPrenom(prenom);
        user.get().setMail(mail);
        user.get().setPassword(password);
    }

    // Delete
    public void deleteUser(Long ID) {
        if (!userRepository.existsById(ID)) {
            throw new EntityNotFoundException("L'utilisateur n'existe pas");
        }
        userRepository.deleteById(ID);
    }

    public Utilisateur loginUser(String username, String password) {
        Optional<Utilisateur> useropt = userRepository.findByUsername(username);

        if (useropt.isPresent()) {
            Utilisateur user = useropt.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
            return null;
        }
        return null;
    }
}

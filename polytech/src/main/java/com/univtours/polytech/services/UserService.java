package com.univtours.polytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public void createUser(Utilisateur user) {
        userRepository.save(user);
    }

    // Read Unitaire
    public Utilisateur readUser(int ID) {
        Optional<Utilisateur> user = userRepository.findById(ID);
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
    public void updateUser(int ID, String nom, String prenom, String mail, String password, String username) {
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
    public void deleteUser(int ID) {
        if (!userRepository.existsById(ID)) {
            throw new EntityNotFoundException("L'utilisateur n'existe pas");
        }
        userRepository.deleteById(ID);
    }
}

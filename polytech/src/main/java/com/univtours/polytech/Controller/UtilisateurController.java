package com.univtours.polytech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univtours.polytech.dto.UtilisateurDTO;
import com.univtours.polytech.entity.Utilisateur;
import com.univtours.polytech.mapper.UtilisateurMapper;
import com.univtours.polytech.services.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService userService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    // CREATE
    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUser(@RequestBody UtilisateurDTO dto) {
        Utilisateur entity = utilisateurMapper.toEntity(dto);
        userService.createUser(entity);
        UtilisateurDTO response = utilisateurMapper.toDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ unitaire
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUser(@PathVariable Long id) {
        Utilisateur entity = userService.readUser(id);
        UtilisateurDTO dto = utilisateurMapper.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    // READ liste
    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUsers() {
        List<Utilisateur> entities = userService.readAllUsers();
        List<UtilisateurDTO> dtos = entities.stream()
                .map(utilisateurMapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long id,
            @RequestBody UtilisateurDTO dto) {
        Utilisateur entity = utilisateurMapper.toEntity(dto);
        userService.updateUser(
                id,
                entity.getNom(),
                entity.getPrenom(),
                entity.getMail(),
                entity.getPassword(),
                entity.getUsername());
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UtilisateurDTO> login(@RequestBody UtilisateurDTO loginRequest) {
        Utilisateur user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            return ResponseEntity.ok(utilisateurMapper.toDTO(user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
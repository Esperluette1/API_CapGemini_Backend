package com.univtours.polytech.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByUsername(String username);
}
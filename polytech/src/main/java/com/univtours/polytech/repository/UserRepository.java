package com.univtours.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

}
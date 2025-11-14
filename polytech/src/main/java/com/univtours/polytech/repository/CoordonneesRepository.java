package com.univtours.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Coordonnees;

@Repository
public interface CoordonneesRepository extends JpaRepository<Coordonnees, Integer> {

}
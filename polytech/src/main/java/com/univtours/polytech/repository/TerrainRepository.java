package com.univtours.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univtours.polytech.entity.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
	boolean existsByCoordonneesId(Integer coordonneesId);

}
package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.univtours.polytech.dto.TerrainDTO;
import com.univtours.polytech.entity.Terrain;

@Mapper(componentModel = "spring")
public interface TerrainMapper {
    
    @Mapping(target = "coordonnees", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Terrain toEntity(TerrainDTO dto);
    
    @Mapping(target = "coordonneesId", source = "coordonnees.id")
    TerrainDTO toDTO(Terrain entity);
}
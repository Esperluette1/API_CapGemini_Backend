package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import com.univtours.polytech.dto.TerrainDTO;
import com.univtours.polytech.entity.Terrain;

@Mapper(componentModel = "spring")
public interface TerrainMapper {
    Terrain toEntity(TerrainDTO dto);
    TerrainDTO toDTO(Terrain entity);
}

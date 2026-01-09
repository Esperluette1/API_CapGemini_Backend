package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.univtours.polytech.dto.CoordonneesDTO;
import com.univtours.polytech.entity.Coordonnees;

@Mapper(componentModel = "spring")
public interface CoordonneesMapper {
    
    @Mapping(target = "terrains", ignore = true)
    Coordonnees toEntity(CoordonneesDTO dto);
    
    CoordonneesDTO toDTO(Coordonnees entity);
}
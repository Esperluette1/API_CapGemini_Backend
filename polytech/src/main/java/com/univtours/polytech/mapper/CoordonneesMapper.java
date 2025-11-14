package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import com.univtours.polytech.dto.CoordonneesDTO;
import com.univtours.polytech.entity.Coordonnees;

@Mapper(componentModel = "spring")
public interface CoordonneesMapper {
    Coordonnees toEntity(CoordonneesDTO dto);
    CoordonneesDTO toDTO(Coordonnees entity);
}

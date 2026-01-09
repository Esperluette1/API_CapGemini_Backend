package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.univtours.polytech.dto.UtilisateurDTO;
import com.univtours.polytech.entity.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    
    @Mapping(target = "reservations", ignore = true)
    Utilisateur toEntity(UtilisateurDTO dto);
    
    UtilisateurDTO toDTO(Utilisateur entity);
}
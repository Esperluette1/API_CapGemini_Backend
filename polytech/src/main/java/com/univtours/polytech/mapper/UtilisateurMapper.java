package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;

import com.univtours.polytech.dto.UtilisateurDTO;
import com.univtours.polytech.entity.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDTO dto);
    UtilisateurDTO toDTO(Utilisateur entity);
}

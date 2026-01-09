package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.univtours.polytech.dto.ReservationDTO;
import com.univtours.polytech.entity.Reservation;

@Mapper(componentModel = "spring")
public interface  ReservationMapper {

    @Mapping(target = "utilisateur", ignore = true)
    @Mapping(target = "terrain", ignore = true)
    @Mapping(source = "utilisateurId", target = "utilisateur_id")
    @Mapping(source = "terrainId", target = "terrain_id")
    Reservation toEntity(ReservationDTO dto);

    @Mapping(source = "utilisateur_id", target = "utilisateurId")
    @Mapping(source = "terrain_id", target = "terrainId")
    ReservationDTO toDTO(Reservation entity);
}
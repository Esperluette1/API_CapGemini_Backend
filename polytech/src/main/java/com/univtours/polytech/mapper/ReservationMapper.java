package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.univtours.polytech.dto.ReservationDTO;
import com.univtours.polytech.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    
    @Mapping(target = "utilisateur", ignore = true)
    @Mapping(target = "terrain", ignore = true)
    Reservation toEntity(ReservationDTO dto);
    
    ReservationDTO toDTO(Reservation entity);
}
package com.univtours.polytech.mapper;

import org.mapstruct.Mapper;
import com.univtours.polytech.dto.ReservationDTO;
import com.univtours.polytech.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationDTO dto);
    ReservationDTO toDTO(Reservation entity);
}

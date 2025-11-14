package com.univtours.polytech.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private int utilisateur_id;
    private int terrain_id;
    private int reservation;
}

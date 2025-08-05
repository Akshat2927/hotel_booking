package com.backend.HotelBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelResponseDTO {

    private Long id;

    private String name;
    private String city;
    private int totalRooms;
    private double pricePerNight;
}

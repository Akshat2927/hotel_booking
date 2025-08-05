package com.backend.HotelBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelAddDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotNull(message = "Total rooms must be provided")
    @Positive(message = "Total rooms must be positive")
    private int totalRooms;

    @NotNull(message = "Price for single room must be provided")
    @Positive(message = "price per night must be positive")
    private double pricePerNight;
}

package com.backend.HotelBooking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingHotelDTO {

    @NotNull(message = "Hotel ID must be provided")
    private Long hotelId;

    @NotBlank(message = "Customer name should not be blank")
    private String customerName;

    @NotNull(message = "Check-in Date must be provided")
    @FutureOrPresent
    private LocalDate checkInDate;

    @NotNull(message = "Check-out Date must be provided")
    @Future
    private LocalDate checkOutDate;
}
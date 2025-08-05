package com.backend.HotelBooking.dto;

import jakarta.persistence.NamedStoredProcedureQueries;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingHotelResponseDTO {
    private String message;
    private Long hotelId;
    private String hotelName;
    private String city;
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}

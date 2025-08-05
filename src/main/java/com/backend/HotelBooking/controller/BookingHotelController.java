package com.backend.HotelBooking.controller;

import com.backend.HotelBooking.dto.BookingHotelDTO;
import com.backend.HotelBooking.dto.BookingHotelResponseDTO;
import com.backend.HotelBooking.service.BookingHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingHotelController {

    @Autowired
    BookingHotelService bookingHotelService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingHotelResponseDTO> bookHotel(@Valid @RequestBody BookingHotelDTO bookingHotelDTO){
        return bookingHotelService.bookHotel(bookingHotelDTO);
    }
}

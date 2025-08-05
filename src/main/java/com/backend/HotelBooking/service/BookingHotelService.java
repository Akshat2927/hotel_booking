package com.backend.HotelBooking.service;

import com.backend.HotelBooking.dto.BookingHotelDTO;
import com.backend.HotelBooking.dto.BookingHotelResponseDTO;
import com.backend.HotelBooking.entity.BookHotel;
import com.backend.HotelBooking.entity.Hotel;
import com.backend.HotelBooking.repository.BookingHotelRespository;
import com.backend.HotelBooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingHotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    BookingHotelRespository bookingHotelRespository;

    public ResponseEntity<BookingHotelResponseDTO> bookHotel(BookingHotelDTO bookingHotelDTO) {
        Optional<Hotel> getHotel = hotelRepository.findById(bookingHotelDTO.getHotelId());
        if (getHotel.isEmpty()){
            return ResponseEntity
                    .badRequest().body(BookingHotelResponseDTO.builder()
                            .message("Hotel with id "+bookingHotelDTO.getHotelId()+" not found")
                            .build());
        }
        if (bookingHotelDTO.getCheckOutDate().isBefore(bookingHotelDTO.getCheckInDate())){
            return ResponseEntity.badRequest()
                    .body(BookingHotelResponseDTO.builder()
                            .message("Check-out date must be after check-in date")
                            .build());
        }

        Hotel hotel = getHotel.get();
        BookHotel bookHotel = BookHotel.builder()
                .customerName(bookingHotelDTO.getCustomerName())
                .checkInDate(bookingHotelDTO.getCheckInDate())
                .checkOutDate(bookingHotelDTO.getCheckOutDate())
                .hotel(hotel)
                .build();

        BookHotel savedBook = bookingHotelRespository.save(bookHotel);
        BookingHotelResponseDTO responseDTO = BookingHotelResponseDTO.builder()
                .message("Hotel Booked Successfully")
                .hotelId(hotel.getId())
                .hotelName(hotel.getName())
                .city(hotel.getCity())
                .customerName(bookingHotelDTO.getCustomerName())
                .checkInDate(bookingHotelDTO.getCheckInDate())
                .checkOutDate(bookingHotelDTO.getCheckOutDate())
                .build();

        return ResponseEntity.ok(responseDTO);
    }
}

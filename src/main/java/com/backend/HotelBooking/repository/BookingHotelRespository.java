package com.backend.HotelBooking.repository;

import com.backend.HotelBooking.entity.BookHotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingHotelRespository extends JpaRepository<BookHotel,Long> {
}

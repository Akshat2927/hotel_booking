package com.backend.HotelBooking.repository;

import com.backend.HotelBooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel , Long> {
    List<Hotel> findByCityIgnoreCase(String city);
}

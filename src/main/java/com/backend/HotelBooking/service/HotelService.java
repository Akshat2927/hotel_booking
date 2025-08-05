package com.backend.HotelBooking.service;

import com.backend.HotelBooking.dto.HotelAddDTO;
import com.backend.HotelBooking.dto.HotelResponseDTO;
import com.backend.HotelBooking.entity.Hotel;
import com.backend.HotelBooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public ResponseEntity<HotelResponseDTO> addHotel(HotelAddDTO hotelAddDTO) {
        Hotel hotel = Hotel.builder()
                .name(hotelAddDTO.getName())
                .city(hotelAddDTO.getCity())
                .totalRooms(hotelAddDTO.getTotalRooms())
                .pricePerNight(hotelAddDTO.getPricePerNight())
                .build();

        Hotel savedHotel = hotelRepository.save(hotel);
        HotelResponseDTO responseDTO = mapToResponseDTO(savedHotel);
        return ResponseEntity.ok(responseDTO);
    }

    private HotelResponseDTO mapToResponseDTO(Hotel savedHotel) {
        return new HotelResponseDTO(
                savedHotel.getId(),
                savedHotel.getName(),
                savedHotel.getCity(),
                savedHotel.getTotalRooms(),
                savedHotel.getPricePerNight()
        );
    }

    public ResponseEntity<List<HotelResponseDTO>> getHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        if (hotels.isEmpty()){
            return ResponseEntity
                    .noContent().build();
        }
        List<HotelResponseDTO> hotelList = new ArrayList<>();
        for(Hotel hotel : hotels){
            hotelList.add(mapToResponseDTO(hotel));
        }
        return ResponseEntity.ok(hotelList);
    }

    public ResponseEntity<List<HotelResponseDTO>> getHotelByCity(String city) {
        List<Hotel> hotels = hotelRepository.findByCityIgnoreCase(city);
        if (hotels.isEmpty()){
            return ResponseEntity
                    .noContent().build();
        }
        List<HotelResponseDTO> hotelLIstByCity = new ArrayList<>();
        for(Hotel hotel : hotels){
            hotelLIstByCity.add(mapToResponseDTO(hotel));
        }
        return ResponseEntity.ok(hotelLIstByCity);
    }
}

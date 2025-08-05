package com.backend.HotelBooking.controller;

import com.backend.HotelBooking.dto.HotelAddDTO;
import com.backend.HotelBooking.dto.HotelResponseDTO;
import com.backend.HotelBooking.service.HotelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping("/hotels")
    public ResponseEntity<HotelResponseDTO> addHotel(@Valid @RequestBody HotelAddDTO hotelAddDTO){
        return hotelService.addHotel(hotelAddDTO);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelResponseDTO>> getHotel(){
        return hotelService.getHotel();
    }

    @GetMapping("/hotels/search")
    public ResponseEntity<List<HotelResponseDTO>> getHotelByCity(@RequestParam @NotBlank(message = "City name must not be blank")String city){
        return hotelService.getHotelByCity(city);
    }
}

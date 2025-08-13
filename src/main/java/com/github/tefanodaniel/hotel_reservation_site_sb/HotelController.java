/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author stefa
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelRepository repository;

    public HotelController(HotelRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
    }
    
    @PostMapping
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        
        // TODO: Calculate average star rating of hotel
        
        return repository.save(hotel);
    }
}

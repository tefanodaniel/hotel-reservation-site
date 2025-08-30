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
    private final ReviewRepository review_repository;

    public HotelController(HotelRepository repository, ReviewRepository review_repository) {
        this.repository = repository;
        this.review_repository = review_repository;
    }
    
    @PostMapping
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return repository.save(hotel);
    }
    
    @GetMapping
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        Hotel hotel = repository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setHotel_avg_rating(getHotelAverageRating(id));
        repository.save(hotel);
        return hotel;
    }
    
    @PostMapping("/{id}")
    public Hotel updateHotelById(@PathVariable Long id, @Valid @RequestBody Hotel hotel) {
        return repository.findById(id)
                .map( oldHotel -> {
                    oldHotel.setHotel_name(hotel.hotel_name);
                    oldHotel.setHotel_address(hotel.hotel_address);
                    oldHotel.setHotel_distance(hotel.hotel_distance);
                    oldHotel.setHotel_phone(hotel.hotel_phone);
                    oldHotel.setHotel_stars(hotel.hotel_stars);                    
                    oldHotel.setHotel_avg_rating(hotel.hotel_avg_rating);
                    oldHotel.setHotel_price_min(hotel.hotel_price_min);
                    oldHotel.setHotel_price_max(hotel.hotel_price_max);
                    oldHotel.setHotel_availability(hotel.hotel_availability);
                    oldHotel.setHotel_city(hotel.hotel_city);
                    return repository.save(oldHotel);
                }).orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    private String getHotelAverageRating(Long hotel_id) {
       List<Review> reviews = this.review_repository.findByHotelId(hotel_id);
       double avg_rating = 0;
       if (!reviews.isEmpty()) {
            for (Review r : reviews) {
                avg_rating += r.getRating();
            }
            avg_rating /= reviews.size();
       }
       else {
           return "no ratings yet";
       }
       return Double.toString(avg_rating);
    }
}

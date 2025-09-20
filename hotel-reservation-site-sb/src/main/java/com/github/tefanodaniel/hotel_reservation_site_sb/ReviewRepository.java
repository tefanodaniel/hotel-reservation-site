/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author stefa
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    @Query("SELECT R FROM Review R WHERE R.hotel_id = ?1")
    List<Review> findByHotelId(Long hotel_id);
    
}

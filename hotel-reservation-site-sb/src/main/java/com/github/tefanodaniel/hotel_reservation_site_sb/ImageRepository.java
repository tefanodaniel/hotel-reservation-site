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
public interface ImageRepository extends JpaRepository<Image, Long>  {
    @Query("SELECT I FROM Image I WHERE I.hotel_id = ?1")
    List<Image> findByHotelId(Long hotel_id);
}

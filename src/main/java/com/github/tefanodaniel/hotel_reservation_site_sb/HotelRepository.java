/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author stefa
 */
public interface HotelRepository extends JpaRepository<Hotel, Long>  {
    
}

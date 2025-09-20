/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author stefa
 */
interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("SELECT U FROM User U WHERE U.username = ?1")
    User findByUsername(String username);
}

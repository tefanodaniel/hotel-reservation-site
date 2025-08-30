package com.github.tefanodaniel.hotel_reservation_site_sb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stefa
 */
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    Long hotel_id;
    
    @Column(name="hotel_name")
    String hotel_name;
    
    @Column(name="hotel_address")
    String hotel_address;
    
    @Column(name="hotel_city")
    String hotel_city;
    
    @Column(name="hotel_distance")
    String hotel_distance;
    
    @Column(name="hotel_phone")
    String hotel_phone;
    
    @Column(name="hotel_stars")
    int hotel_stars; 
    
    @Column(name="hotel_avg_rating")
    String hotel_avg_rating;
    
    @Column(name="hotel_price_min")
    int hotel_price_min;
    
    @Column(name="hotel_price_max")
    int hotel_price_max;
    
    @Column(name="hotel_availability")
    String hotel_availability;
    
    
    public Hotel(Long hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_distance, String hotel_phone, int hotel_stars, String hotel_avg_rating, int hotel_price_min, int hotel_price_max, String hotel_availability ) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_address = hotel_address;
        this.hotel_distance = hotel_distance;
        this.hotel_phone = hotel_phone;
        this.hotel_stars = hotel_stars;
        this.hotel_avg_rating = hotel_avg_rating;
        this.hotel_price_min = hotel_price_min;
        this.hotel_price_max = hotel_price_max;
        this.hotel_availability = hotel_availability;
    }
    
    public Hotel() {}

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }


    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }
    
    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }


    public String getHotel_distance() {
        return hotel_distance;
    }

    public void setHotel_distance(String hotel_distance) {
        this.hotel_distance = hotel_distance;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }
    
    public int getHotel_stars() {
        return hotel_stars;
    }
    
    public void setHotel_stars(int hotel_stars) {
        this.hotel_stars = hotel_stars;
    }
    
    public String getHotel_avg_rating() {
        return hotel_avg_rating;
    }

    public void setHotel_avg_rating(String hotel_avg_rating) {
        this.hotel_avg_rating = hotel_avg_rating;
    }

    public int getHotel_price_min() {
        return hotel_price_min;
    }

    public void setHotel_price_min(int hotel_price_min) {
        this.hotel_price_min = hotel_price_min;
    }

    public int getHotel_price_max() {
        return hotel_price_max;
    }

    public void setHotel_price_max(int hotel_price_max) {
        this.hotel_price_max = hotel_price_max;
    }

    public String getHotel_availability() {
        return hotel_availability;
    }

    public void setHotel_availability(String hotel_availability) {
        this.hotel_availability = hotel_availability;
    }   
    
}

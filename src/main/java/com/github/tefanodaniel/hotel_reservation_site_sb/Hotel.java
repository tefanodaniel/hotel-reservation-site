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
    int hotel_id;
    
    @Column(name="hotel_name")
    String hotel_name;
    
    @Column(name="hotel_stars")
    String hotel_stars;
    
    @Column(name="hotel_location")
    String hotel_location;
    
    @Column(name="hotel_distance")
    String hotel_distance;
    
    @Column(name="hotel_phone")
    String hotel_phone;
    
    @Column(name="hotel_price_min")
    String hotel_price_min;
    
    @Column(name="hotel_price_max")
    String hotel_price_max;
    
    @Column(name="hotel_availability")
    String hotel_availability;
    
    @Column(name="hotel_city")
    String hotel_city;

    public Hotel(int hotel_id, String hotel_name, String hotel_stars, String hotel_location, String hotel_distance, String hotel_phone, String hotel_price_min, String hotel_price_max, String hotel_availability, String hotel_city) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_distance = hotel_distance;
        this.hotel_phone = hotel_phone;
        this.hotel_location = hotel_location;
        this.hotel_price_min = hotel_price_min;
        this.hotel_price_max = hotel_price_max;
        this.hotel_availability = hotel_availability;
        this.hotel_stars = hotel_stars;
    }
    
    public Hotel() {}

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_stars() {
        return hotel_stars;
    }

    public void setHotel_stars(String hotel_stars) {
        this.hotel_stars = hotel_stars;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
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

    public String getHotel_price_min() {
        return hotel_price_min;
    }

    public void setHotel_price_min(String hotel_price_min) {
        this.hotel_price_min = hotel_price_min;
    }

    public String getHotel_price_max() {
        return hotel_price_max;
    }

    public void setHotel_price_max(String hotel_price_max) {
        this.hotel_price_max = hotel_price_max;
    }

    public String getHotel_availability() {
        return hotel_availability;
    }

    public void setHotel_availability(String hotel_availability) {
        this.hotel_availability = hotel_availability;
    }   
    
    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }
}

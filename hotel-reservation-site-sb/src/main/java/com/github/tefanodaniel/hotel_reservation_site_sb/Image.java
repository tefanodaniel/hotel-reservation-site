/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author stefa
 */
@Entity
@Table(name="photos")
public class Image {
    
    @Id
    Long photos_id;
    
    @Column(name="hotel_id")
    Long hotel_id;
    
    @Column(name="link")
    String link;

    public Image(Long photos_id, Long hotel_id, String link) {
        this.photos_id = photos_id;
        this.hotel_id = hotel_id;
        this.link = link;
    }

    public Image() {
    }

    public Long getPhotos_id() {
        return photos_id;
    }

    public void setPhotos_id(Long photos_id) {
        this.photos_id = photos_id;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

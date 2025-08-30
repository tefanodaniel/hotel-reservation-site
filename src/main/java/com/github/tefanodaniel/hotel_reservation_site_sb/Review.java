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
@Table(name="hotel_reviews")
public class Review {
    
    @Id
    Long review_id;
    
    @Column(name="hotel_id")
    Long hotel_id;
    
    @Column(name="user_id")
    Long user_id;
    
    @Column(name="comment")
    String comment;
    
    @Column(name="rating")
    int rating;

    public Review(Long review_id, Long hotel_id, Long user_id, String comment, int rating) {
        this.review_id = review_id;
        this.hotel_id = hotel_id;
        this.user_id = user_id;
        this.comment = comment;
        this.rating = rating;
    }

    public Review() {
    }

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}

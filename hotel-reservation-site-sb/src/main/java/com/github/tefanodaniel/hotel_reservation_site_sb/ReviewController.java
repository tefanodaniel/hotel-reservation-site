/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 *
 * @author stefa
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    private final ReviewRepository repository;

    public ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }
    
    // Create
    @PostMapping
    public Review createReview(@Valid @RequestBody Review review) {
        return repository.save(review);
    }
    
    // Read
    @GetMapping
    public List<Review> getAllReviews() {
        return repository.findAll();
    }
    
    // See how these routes look in the address bar...
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        Review review = repository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        return repository.save(review);
    }
    
    @GetMapping("/forhotel{id}")
    public List<Review> getReviewsForHotelId(@PathVariable Long hotel_id) {
        return repository.findByHotelId(hotel_id);
    }
    
    // Update?
    @PostMapping("/{id}")
    public Review updateReviewById(@PathVariable Long id, @Valid @RequestBody Review review) {
        return repository.findById(id)
                .map( newReview -> {
                    newReview.setComment(review.comment);
                    newReview.setHotel_id(review.hotel_id);
                    newReview.setRating(review.rating);
                    newReview.setUser_id(review.user_id);
                    return repository.save(newReview);
                }).orElseThrow(() -> new RuntimeException("Review not found"));
    }
    
    // Delete
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}

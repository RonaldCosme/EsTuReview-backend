package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ReviewDTO;
import com.estureview.backend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.createReview(reviewDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> listAllReviews() {
        return ResponseEntity.ok(reviewService.listAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> findReviewById(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewService.findReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ReviewDTO> updateReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.updateReview(reviewDTO));
    }
}
package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ReviewDTO;
import com.estureview.backend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        ReviewDTO reviewDTO = reviewService.findById(id);
        return reviewDTO != null ?
                new ResponseEntity<>(reviewDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@RequestBody ReviewDTO reviewDTO, @PathVariable Long id) {
        ReviewDTO foundReview = reviewService.findById(id);
        if (reviewDTO.getComment()!=null) {
            foundReview.setComment(reviewDTO.getComment());
        }
        if (reviewDTO.getRating()!=null) {
            foundReview.setRating(reviewDTO.getRating());
        }
        if (reviewDTO.getReviewDate()!=null) {
            foundReview.setReviewDate(reviewDTO.getReviewDate());
        }
        if (reviewDTO.getStatus()!=null) {
            foundReview.setStatus(reviewDTO.getStatus());
        }
        if (reviewDTO.getProfessorId()!=null) {
            foundReview.setProfessorId(reviewDTO.getProfessorId());
        }
        if (reviewDTO.getCourseId()!=null) {
            foundReview.setCourseId(reviewDTO.getCourseId());
        }
        ReviewDTO newReview = reviewService.save(foundReview);
        return new ResponseEntity<>(newReview, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        return new ResponseEntity<>(reviewService.save(reviewDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


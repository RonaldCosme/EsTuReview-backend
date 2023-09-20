package com.estureview.backend.services;

import com.estureview.backend.entities.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);
    List<Review> listAllReviews();
    Review findReviewById(Long id);
    void deleteReview(Long id);
    Review updateReview(Review review);
}
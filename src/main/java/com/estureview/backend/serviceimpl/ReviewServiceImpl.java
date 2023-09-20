package com.estureview.backend.serviceimpl;


import com.estureview.backend.entities.Review;
import com.estureview.backend.repositories.ReviewRepository;
import com.estureview.backend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review updateReview(Review review) {
        if (review.getReviewId() == null) {
            return null; // or throw an exception
        }
        return reviewRepository.save(review);
    }
}

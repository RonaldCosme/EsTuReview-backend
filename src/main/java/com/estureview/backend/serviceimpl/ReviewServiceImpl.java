package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewDTO;
import com.estureview.backend.entities.Review;
import com.estureview.backend.repositories.ReviewRepository;
import com.estureview.backend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewDTO::new)
                .orElse(null);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        // TODO: Map review properties from reviewDTO here...
        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            // TODO: Update review properties from reviewDTO here...
            review = reviewRepository.save(review);
        }
        return new ReviewDTO(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
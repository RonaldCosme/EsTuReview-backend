package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewDTO;
import java.util.List;

public interface ReviewService {

    ReviewDTO createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> listAllReviews();
    ReviewDTO findReviewById(Integer id);
    void deleteReview(Integer id);
    ReviewDTO updateReview(ReviewDTO reviewDTO);
}
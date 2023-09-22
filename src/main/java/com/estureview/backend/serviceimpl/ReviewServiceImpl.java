package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewDTO;
import com.estureview.backend.entities.Review;
import com.estureview.backend.repositories.ReviewRepository;
import com.estureview.backend.services.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review);
        review = reviewRepository.save(review);
        BeanUtils.copyProperties(review, reviewDTO);
        return reviewDTO;
    }

    @Override
    public List<ReviewDTO> listAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDTO reviewDTO = new ReviewDTO();
            BeanUtils.copyProperties(review, reviewDTO);
            reviewDTOs.add(reviewDTO);
        }
        return reviewDTOs;
    }

    @Override
    public ReviewDTO findReviewById(Integer id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            ReviewDTO reviewDTO = new ReviewDTO();
            BeanUtils.copyProperties(reviewOptional.get(), reviewDTO);
            return reviewDTO;
        }
        return null;
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        if (reviewDTO.getId() == null) {
            throw new IllegalArgumentException("El ID de la revisión es necesario para actualizar");
        }
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review);
        review = reviewRepository.save(review);
        BeanUtils.copyProperties(review, reviewDTO);
        return reviewDTO;
    }
}
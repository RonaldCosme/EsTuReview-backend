package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewDTO;
import com.estureview.backend.entities.Review;
import com.estureview.backend.repositories.ReviewRepository;
import com.estureview.backend.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO findById(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        return review != null ? modelMapper.map(review, ReviewDTO.class) : null;
    }

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        review = reviewRepository.save(review);
        return modelMapper.map(review, ReviewDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}

package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    ReviewDTO findById(Long id);
    ReviewDTO save(ReviewDTO reviewDTO);
    void deleteById(Long id);
}
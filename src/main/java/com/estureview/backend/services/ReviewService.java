package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    ReviewDTO findById(Integer id);
    ReviewDTO save(ReviewDTO reviewDTO);
    void deleteById(Integer id);
}
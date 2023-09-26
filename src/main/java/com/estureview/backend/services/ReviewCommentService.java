package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewCommentDTO;

import java.util.List;

public interface ReviewCommentService {
    List<ReviewCommentDTO> findAll();
    ReviewCommentDTO findById(Integer id);
    ReviewCommentDTO save(ReviewCommentDTO reviewCommentDTO);
    void deleteById(Integer id);
}
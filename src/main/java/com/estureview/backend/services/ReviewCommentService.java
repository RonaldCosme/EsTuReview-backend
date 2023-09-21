package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewCommentDTO;
import java.util.List;

public interface ReviewCommentService {
    List<ReviewCommentDTO> getAllReviewComments();
    ReviewCommentDTO getReviewCommentById(Long id);
    ReviewCommentDTO createReviewComment(ReviewCommentDTO reviewCommentDTO);
    ReviewCommentDTO updateReviewComment(Long id, ReviewCommentDTO reviewCommentDTO);
    void deleteReviewComment(Long id);
}
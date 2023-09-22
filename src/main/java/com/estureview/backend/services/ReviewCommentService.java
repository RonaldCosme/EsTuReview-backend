package com.estureview.backend.services;

import com.estureview.backend.dtos.ReviewCommentDTO;
import java.util.List;

public interface ReviewCommentService {

    ReviewCommentDTO createReviewComment(ReviewCommentDTO reviewCommentDTO);
    List<ReviewCommentDTO> listAllReviewComments();
    ReviewCommentDTO findReviewCommentById(Integer id);
    void deleteReviewComment(Integer id);
    ReviewCommentDTO updateReviewComment(ReviewCommentDTO reviewCommentDTO);
}
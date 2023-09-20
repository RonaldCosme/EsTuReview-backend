package com.estureview.backend.services;

import com.estureview.backend.entities.ReviewComment;

import java.util.List;

public interface ReviewCommentService {
    ReviewComment createReviewComment(ReviewComment reviewComment);
    List<ReviewComment> listAllReviewComments();
    ReviewComment findReviewCommentById(Long id);
    void deleteReviewComment(Long id);
    ReviewComment updateReviewComment(ReviewComment reviewComment);
}
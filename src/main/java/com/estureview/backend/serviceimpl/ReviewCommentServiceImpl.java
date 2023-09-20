package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.ReviewComment;
import com.estureview.backend.repositories.ReviewCommentRepository;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    @Override
    public ReviewComment createReviewComment(ReviewComment reviewComment) {
        return reviewCommentRepository.save(reviewComment);
    }

    @Override
    public List<ReviewComment> listAllReviewComments() {
        return reviewCommentRepository.findAll();
    }

    @Override
    public ReviewComment findReviewCommentById(Long id) {
        Optional<ReviewComment> comment = reviewCommentRepository.findById(id);
        return comment.orElse(null);
    }

    @Override
    public void deleteReviewComment(Long id) {
        reviewCommentRepository.deleteById(id);
    }

    @Override
    public ReviewComment updateReviewComment(ReviewComment reviewComment) {
        if (reviewComment.getCommentId() == null) {
            return null; // or throw an exception
        }
        return reviewCommentRepository.save(reviewComment);
    }
}

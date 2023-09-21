package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.entities.ReviewComment;
import com.estureview.backend.repositories.ReviewCommentRepository;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    @Override
    public List<ReviewCommentDTO> getAllReviewComments() {
        return reviewCommentRepository.findAll().stream()
                .map(ReviewCommentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewCommentDTO getReviewCommentById(Long id) {
        return reviewCommentRepository.findById(id)
                .map(ReviewCommentDTO::new)
                .orElse(null);
    }

    @Override
    public ReviewCommentDTO createReviewComment(ReviewCommentDTO reviewCommentDTO) {
        ReviewComment reviewComment = new ReviewComment();
        reviewComment.setComment_id(reviewCommentDTO.getComment_id());
        reviewComment.setText(reviewCommentDTO.getText());
        reviewComment.setTag(reviewCommentDTO.getTag());
        reviewComment.setComment_date(reviewCommentDTO.getComment_date());
        reviewComment = reviewCommentRepository.save(reviewComment);
        return new ReviewCommentDTO(reviewComment);
    }

    @Override
    public ReviewCommentDTO updateReviewComment(Long id, ReviewCommentDTO reviewCommentDTO) {
        ReviewComment reviewComment = reviewCommentRepository.findById(id).orElse(null);
        if (reviewComment != null) {
            reviewComment.setComment_id(reviewCommentDTO.getComment_id());
            reviewComment.setText(reviewCommentDTO.getText());
            reviewComment.setTag(reviewCommentDTO.getTag());
            reviewComment.setComment_date(reviewCommentDTO.getComment_date());
            reviewComment = reviewCommentRepository.save(reviewComment);
        }
        return new ReviewCommentDTO(reviewComment);
    }

    @Override
    public void deleteReviewComment(Long id) {
        reviewCommentRepository.deleteById(id);
    }
}
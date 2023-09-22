package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.entities.ReviewComment;
import com.estureview.backend.repositories.ReviewCommentRepository;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    @Override
    public ReviewCommentDTO createReviewComment(ReviewCommentDTO reviewCommentDTO) {
        ReviewComment reviewComment = new ReviewComment();
        BeanUtils.copyProperties(reviewCommentDTO, reviewComment);
        reviewComment = reviewCommentRepository.save(reviewComment);
        BeanUtils.copyProperties(reviewComment, reviewCommentDTO);
        return reviewCommentDTO;
    }

    @Override
    public List<ReviewCommentDTO> listAllReviewComments() {
        List<ReviewComment> reviewComments = reviewCommentRepository.findAll();
        List<ReviewCommentDTO> reviewCommentDTOs = new ArrayList<>();
        for (ReviewComment reviewComment : reviewComments) {
            ReviewCommentDTO reviewCommentDTO = new ReviewCommentDTO();
            BeanUtils.copyProperties(reviewComment, reviewCommentDTO);
            reviewCommentDTOs.add(reviewCommentDTO);
        }
        return reviewCommentDTOs;
    }

    @Override
    public ReviewCommentDTO findReviewCommentById(Integer id) {
        Optional<ReviewComment> reviewCommentOptional = reviewCommentRepository.findById(id);
        if (reviewCommentOptional.isPresent()) {
            ReviewCommentDTO reviewCommentDTO = new ReviewCommentDTO();
            BeanUtils.copyProperties(reviewCommentOptional.get(), reviewCommentDTO);
            return reviewCommentDTO;
        }
        return null;
    }

    @Override
    public void deleteReviewComment(Integer id) {
        reviewCommentRepository.deleteById(id);
    }

    @Override
    public ReviewCommentDTO updateReviewComment(ReviewCommentDTO reviewCommentDTO) {
        if (reviewCommentDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del comentario es necesario para actualizar");
        }
        ReviewComment reviewComment = new ReviewComment();
        BeanUtils.copyProperties(reviewCommentDTO, reviewComment);
        reviewComment = reviewCommentRepository.save(reviewComment);
        BeanUtils.copyProperties(reviewComment, reviewCommentDTO);
        return reviewCommentDTO;
    }
}

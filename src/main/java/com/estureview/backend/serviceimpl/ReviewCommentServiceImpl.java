package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.entities.ReviewComment;
import com.estureview.backend.repositories.ReviewCommentRepository;
import com.estureview.backend.services.ReviewCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReviewCommentDTO> findAll() {
        return reviewCommentRepository.findAll()
                .stream()
                .map(reviewComment -> modelMapper.map(reviewComment, ReviewCommentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewCommentDTO findById(Long id) {
        ReviewComment reviewComment = reviewCommentRepository.findById(id).orElse(null);
        return reviewComment != null ? modelMapper.map(reviewComment, ReviewCommentDTO.class) : null;
    }

    @Override
    public ReviewCommentDTO save(ReviewCommentDTO reviewCommentDTO) {
        ReviewComment reviewComment = modelMapper.map(reviewCommentDTO, ReviewComment.class);
        reviewComment = reviewCommentRepository.save(reviewComment);
        return modelMapper.map(reviewComment, ReviewCommentDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        reviewCommentRepository.deleteById(id);
    }
}

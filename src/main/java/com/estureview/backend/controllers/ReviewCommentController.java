package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://www.estureview.online", "https://www.estureview.online"})


@RestController
@RequestMapping("/api/reviewComments")
public class ReviewCommentController {

    @Autowired
    private ReviewCommentService reviewCommentService;

    @GetMapping
    public ResponseEntity<List<ReviewCommentDTO>> getAllReviewComments() {
        return new ResponseEntity<>(reviewCommentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewCommentDTO> getReviewCommentById(@PathVariable Long id) {
        ReviewCommentDTO reviewCommentDTO = reviewCommentService.findById(id);
        return reviewCommentDTO != null ?
                new ResponseEntity<>(reviewCommentDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewCommentDTO> updateReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO, @PathVariable Long id) {
        ReviewCommentDTO foundReviewComment = reviewCommentService.findById(id);
        if (reviewCommentDTO.getText()!=null) {
            foundReviewComment.setText(reviewCommentDTO.getText());
        }
        if (reviewCommentDTO.getTag()!=null) {
            foundReviewComment.setTag(reviewCommentDTO.getTag());
        }
        if (reviewCommentDTO.getCommentDate()!=null) {
            foundReviewComment.setCommentDate(reviewCommentDTO.getCommentDate());
        }
        if (reviewCommentDTO.getReviewId()!=null) {
            foundReviewComment.setReviewId(reviewCommentDTO.getReviewId());
        }
        ReviewCommentDTO newReviewComment = reviewCommentService.save(foundReviewComment);
        return new ResponseEntity<>(newReviewComment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewCommentDTO> createReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO) {
        return new ResponseEntity<>(reviewCommentService.save(reviewCommentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewComment(@PathVariable Long id) {
        reviewCommentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

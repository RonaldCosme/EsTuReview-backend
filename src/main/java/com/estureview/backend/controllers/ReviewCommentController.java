package com.estureview.backend.controllers;


import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review-comments")
public class ReviewCommentController {

    @Autowired
    private ReviewCommentService reviewCommentService;

    @PostMapping
    public ResponseEntity<ReviewCommentDTO> createReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO) {
        return ResponseEntity.ok(reviewCommentService.createReviewComment(reviewCommentDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReviewCommentDTO>> listAllReviewComments() {
        return ResponseEntity.ok(reviewCommentService.listAllReviewComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewCommentDTO> findReviewCommentById(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewCommentService.findReviewCommentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewComment(@PathVariable Integer id) {
        reviewCommentService.deleteReviewComment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ReviewCommentDTO> updateReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO) {
        return ResponseEntity.ok(reviewCommentService.updateReviewComment(reviewCommentDTO));
    }
}
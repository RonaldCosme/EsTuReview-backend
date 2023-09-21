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

    @GetMapping
    public ResponseEntity<List<ReviewCommentDTO>> getAllReviewComments() {
        return ResponseEntity.ok(reviewCommentService.getAllReviewComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewCommentDTO> getReviewCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewCommentService.getReviewCommentById(id));
    }

    @PostMapping
    public ResponseEntity<ReviewCommentDTO> createReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO) {
        return ResponseEntity.ok(reviewCommentService.createReviewComment(reviewCommentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewCommentDTO> updateReviewComment(@PathVariable Long id, @RequestBody ReviewCommentDTO reviewCommentDTO) {
        return ResponseEntity.ok(reviewCommentService.updateReviewComment(id, reviewCommentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewComment(@PathVariable Long id) {
        reviewCommentService.deleteReviewComment(id);
        return ResponseEntity.noContent().build();
    }
}

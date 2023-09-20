package com.estureview.backend.controllers;

import com.estureview.backend.entities.ReviewComment;
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
    public ResponseEntity<ReviewComment> createReviewComment(@RequestBody ReviewComment reviewComment) {
        return ResponseEntity.ok(reviewCommentService.createReviewComment(reviewComment));
    }

    @GetMapping
    public ResponseEntity<List<ReviewComment>> listAllReviewComments() {
        return ResponseEntity.ok(reviewCommentService.listAllReviewComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewComment> findReviewCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewCommentService.findReviewCommentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewComment> updateReviewComment(@PathVariable Long id, @RequestBody ReviewComment reviewComment) {
        reviewComment.setCommentId(id);
        return ResponseEntity.ok(reviewCommentService.updateReviewComment(reviewComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewComment(@PathVariable Long id) {
        reviewCommentService.deleteReviewComment(id);
        return ResponseEntity.noContent().build();
    }
}

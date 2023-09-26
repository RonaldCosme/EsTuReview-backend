package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ReviewCommentDTO;
import com.estureview.backend.services.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ReviewCommentDTO> getReviewCommentById(@PathVariable Integer id) {
        ReviewCommentDTO reviewCommentDTO = reviewCommentService.findById(id);
        return reviewCommentDTO != null ?
                new ResponseEntity<>(reviewCommentDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ReviewCommentDTO> createReviewComment(@RequestBody ReviewCommentDTO reviewCommentDTO) {
        return new ResponseEntity<>(reviewCommentService.save(reviewCommentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewComment(@PathVariable Integer id) {
        reviewCommentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

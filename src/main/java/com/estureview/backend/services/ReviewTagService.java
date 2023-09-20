package com.estureview.backend.services;

import com.estureview.backend.entities.ReviewTag;

import java.util.List;

public interface ReviewTagService {
    ReviewTag createReviewTag(ReviewTag reviewTag);
    List<ReviewTag> listAllReviewTags();
    ReviewTag findReviewTagById(Long id);
    void deleteReviewTag(Long id);
    ReviewTag updateReviewTag(ReviewTag reviewTag);
}
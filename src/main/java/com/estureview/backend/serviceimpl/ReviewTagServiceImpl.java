package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.ReviewTag;
import com.estureview.backend.repositories.ReviewTagRepository;
import com.estureview.backend.services.ReviewTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewTagServiceImpl implements ReviewTagService {

    @Autowired
    private ReviewTagRepository reviewTagRepository;

    @Override
    public ReviewTag createReviewTag(ReviewTag reviewTag) {
        return reviewTagRepository.save(reviewTag);
    }

    @Override
    public List<ReviewTag> listAllReviewTags() {
        return reviewTagRepository.findAll();
    }

    @Override
    public ReviewTag findReviewTagById(Long id) {
        Optional<ReviewTag> tag = reviewTagRepository.findById(id);
        return tag.orElse(null);
    }

    @Override
    public void deleteReviewTag(Long id) {
        reviewTagRepository.deleteById(id);
    }

    @Override
    public ReviewTag updateReviewTag(ReviewTag reviewTag) {
        if (reviewTag.getReviewTagId() == null) {
            return null; // or throw an exception
        }
        return reviewTagRepository.save(reviewTag);
    }
}

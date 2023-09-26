package com.estureview.backend.repositories;
import com.estureview.backend.entities.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Integer> {
}

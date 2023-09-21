package com.estureview.backend.repositories;

import com.estureview.backend.entities.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {
    // Consultas personalizadas aquí
}
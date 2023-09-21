package com.estureview.backend.repositories;

import com.estureview.backend.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Por ejemplo, podrías querer obtener todas las reviews de un profesor específico:
    // List<Review> findByProfessorId(Long professorId);
}

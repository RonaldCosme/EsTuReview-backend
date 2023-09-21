package com.estureview.backend.repositories;

import com.estureview.backend.entities.ModerationAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModerationActionRepository extends JpaRepository<ModerationAction, Long> {
    // Consultas personalizadas aquí
}

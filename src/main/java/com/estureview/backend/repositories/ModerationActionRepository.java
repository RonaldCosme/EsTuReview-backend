package com.estureview.backend.repositories;

import com.estureview.backend.entities.ModerationAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerationActionRepository extends JpaRepository<ModerationAction, Long> {
}

package com.estureview.backend.repositories;

import com.estureview.backend.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
}

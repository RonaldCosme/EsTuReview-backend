package com.estureview.backend.repositories;

import com.estureview.backend.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    // Puedes agregar consultas personalizadas si lo necesitas
}

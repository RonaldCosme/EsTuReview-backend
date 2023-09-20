package com.estureview.backend.repositories;



import com.estureview.backend.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    // Método para buscar una universidad por su nombre
    University findByName(String name);
}
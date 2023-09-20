package com.estureview.backend.services;

import com.estureview.backend.entities.Professor;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(Professor professor);
    List<Professor> listAllProfessors();
    Professor findProfessorById(Long id);
    void deleteProfessor(Long id);
    Professor updateProfessor(Professor professor);
}
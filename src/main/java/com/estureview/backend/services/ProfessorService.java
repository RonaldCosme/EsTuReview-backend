package com.estureview.backend.services;

import com.estureview.backend.dtos.ProfessorDTO;
import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> getAllProfessors();
    ProfessorDTO getProfessorById(Long id);
    ProfessorDTO createProfessor(ProfessorDTO professorDTO);
    ProfessorDTO updateProfessor(Long id, ProfessorDTO professorDTO);
    void deleteProfessor(Long id);
}
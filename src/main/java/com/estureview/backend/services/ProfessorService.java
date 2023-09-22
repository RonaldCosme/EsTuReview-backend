package com.estureview.backend.services;

import com.estureview.backend.dtos.ProfessorDTO;
import java.util.List;

public interface ProfessorService {

    ProfessorDTO createProfessor(ProfessorDTO professorDTO);
    List<ProfessorDTO> listAllProfessors();
    ProfessorDTO findProfessorById(Integer id);
    void deleteProfessor(Integer id);
    ProfessorDTO updateProfessor(ProfessorDTO professorDTO);
}
package com.estureview.backend.services;

import com.estureview.backend.dtos.ProfessorDTO;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> findAll();
    ProfessorDTO findById(Long id);
    ProfessorDTO save(ProfessorDTO professorDTO);
    void deleteById(Long id);
}
package com.estureview.backend.serviceimpl;
import com.estureview.backend.dtos.ProfessorDTO;
import com.estureview.backend.entities.Professor;
import com.estureview.backend.repositories.ProfessorRepository;
import com.estureview.backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream()
                .map(ProfessorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO getProfessorById(Long id) {
        return professorRepository.findById(id)
                .map(ProfessorDTO::new)
                .orElse(null);
    }

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        // TODO: Map professor properties from professorDTO here...
        professor = professorRepository.save(professor);
        return new ProfessorDTO(professor);
    }

    @Override
    public ProfessorDTO updateProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id).orElse(null);
        if (professor != null) {
            // TODO: Update professor properties from professorDTO here...
            professor = professorRepository.save(professor);
        }
        return new ProfessorDTO(professor);
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
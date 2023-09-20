package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.Professor;
import com.estureview.backend.repositories.ProfessorRepository;
import com.estureview.backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> listAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findProfessorById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElse(null);
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public Professor updateProfessor(Professor professor) {
        if (professor.getProfessorId() == null) {
            return null; // or throw an exception
        }
        return professorRepository.save(professor);
    }
}
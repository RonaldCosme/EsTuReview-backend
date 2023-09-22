package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ProfessorDTO;
import com.estureview.backend.entities.Professor;
import com.estureview.backend.repositories.ProfessorRepository;
import com.estureview.backend.services.ProfessorService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        professor = professorRepository.save(professor);
        BeanUtils.copyProperties(professor, professorDTO);
        return professorDTO;
    }

    @Override
    public List<ProfessorDTO> listAllProfessors() {
        List<Professor> professors = professorRepository.findAll();
        List<ProfessorDTO> professorDTOs = new ArrayList<>();
        for (Professor professor : professors) {
            ProfessorDTO professorDTO = new ProfessorDTO();
            BeanUtils.copyProperties(professor, professorDTO);
            professorDTOs.add(professorDTO);
        }
        return professorDTOs;
    }

    @Override
    public ProfessorDTO findProfessorById(Integer id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            ProfessorDTO professorDTO = new ProfessorDTO();
            BeanUtils.copyProperties(professorOptional.get(), professorDTO);
            return professorDTO;
        }
        return null;
    }

    @Override
    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }

    @Override
    public ProfessorDTO updateProfessor(ProfessorDTO professorDTO) {
        if (professorDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del profesor es necesario para actualizar");
        }
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        professor = professorRepository.save(professor);
        BeanUtils.copyProperties(professor, professorDTO);
        return professorDTO;
    }
}
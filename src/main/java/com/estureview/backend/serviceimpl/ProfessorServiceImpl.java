package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ProfessorDTO;
import com.estureview.backend.entities.Professor;
import com.estureview.backend.repositories.ProfessorRepository;
import com.estureview.backend.services.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProfessorDTO> findAll() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> modelMapper.map(professor, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO findById(Integer id) {
        Professor professor = professorRepository.findById(id).orElse(null);
        return professor != null ? modelMapper.map(professor, ProfessorDTO.class) : null;
    }

    @Override
    public ProfessorDTO save(ProfessorDTO professorDTO) {
        Professor professor = modelMapper.map(professorDTO, Professor.class);
        professor = professorRepository.save(professor);
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}

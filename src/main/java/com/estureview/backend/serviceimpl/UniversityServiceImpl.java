package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.entities.University;
import com.estureview.backend.repositories.UniversityRepository;
import com.estureview.backend.services.UniversityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UniversityDTO> findAll() {
        return universityRepository.findAll()
                .stream()
                .map(university -> modelMapper.map(university, UniversityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UniversityDTO findById(Long id) {
        University university = universityRepository.findById(id).orElse(null);
        return university != null ? modelMapper.map(university, UniversityDTO.class) : null;
    }

    @Override
    public UniversityDTO save(UniversityDTO universityDTO) {
        University university = modelMapper.map(universityDTO, University.class);
        university = universityRepository.save(university);
        return modelMapper.map(university, UniversityDTO.class);
    }

    @Override
    public UniversityDTO update(UniversityDTO universityDTO) {
        University university = modelMapper.map(universityDTO, University.class);
        university = universityRepository.save(university);
        return modelMapper.map(university, UniversityDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        universityRepository.deleteById(id);
    }
}

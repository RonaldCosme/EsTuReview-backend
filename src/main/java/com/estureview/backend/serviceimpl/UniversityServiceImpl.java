package com.estureview.backend.serviceimpl;


import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.entities.University;
import com.estureview.backend.repositories.UniversityRepository;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<UniversityDTO> getAllUniversities() {
        return universityRepository.findAll().stream()
                .map(UniversityDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UniversityDTO getUniversityById(Long id) {
        return universityRepository.findById(id)
                .map(UniversityDTO::new)
                .orElse(null);
    }

    @Override
    public UniversityDTO createUniversity(UniversityDTO universityDTO) {
        University university = new University();
        // TODO: Map university properties from universityDTO here...
        university = universityRepository.save(university);
        return new UniversityDTO(university);
    }

    @Override
    public UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO) {
        University university = universityRepository.findById(id).orElse(null);
        if (university != null) {
            // TODO: Update university properties from universityDTO here...
            university = universityRepository.save(university);
        }
        return new UniversityDTO(university);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }
}